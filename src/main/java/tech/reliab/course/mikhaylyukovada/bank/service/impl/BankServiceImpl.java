package tech.reliab.course.mikhaylyukovada.bank.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import tech.reliab.course.mikhaylyukovada.bank.entity.*;
import tech.reliab.course.mikhaylyukovada.bank.exceptions.FailedLoanException;
import tech.reliab.course.mikhaylyukovada.bank.exceptions.ErrorSumException;
import tech.reliab.course.mikhaylyukovada.bank.exceptions.IdNotFoundException;
import tech.reliab.course.mikhaylyukovada.bank.exceptions.WrongNameException;
import tech.reliab.course.mikhaylyukovada.bank.repository.*;
import tech.reliab.course.mikhaylyukovada.bank.service.*;
import tech.reliab.course.mikhaylyukovada.bank.utils.BankComparator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Реализация интерфейса для взаимодействия с банками
 */
public class BankServiceImpl implements BankService {
    private static BankServiceImpl INSTANCE;
    private final ObjectMapper objectMapper = new ObjectMapper();

    private BankServiceImpl() {
        objectMapper.registerModule(new JavaTimeModule());
    }

    public static BankServiceImpl getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new BankServiceImpl();
        }

        return INSTANCE;
    }

    private final BankRepository bankRepository = BankRepository.getInstance();

    private static final String TRANSFER_PATH = "/Users/darmi/LR4/accounts.txt";
    private static final int MIN_CLIENT_RATING = 5000;
    private static final int TOP_BANK_RATING = 50;

    @Override
    public Bank addObject(Bank bank) {
        if (bank.getName().isBlank()) {
            throw new WrongNameException();
        }

        return bankRepository.add(bank);
    }

    @Override
    public Bank updateObject(Bank bank) {
        return bankRepository.update(bank);
    }

    @Override
    public boolean deleteObjectById(Long id) {
        if (id == null) {
            throw new IdNotFoundException();
        }

        return bankRepository.deleteById(id);
    }

    @Override
    public Bank getObjectById(Long id) {
        if (id == null) {
            throw new IdNotFoundException();
        }

        return bankRepository.findById(id);
    }

    @Override
    public List<Bank> getAllObjects() {
        return bankRepository.findAll();
    }

    @Override
    public void outputBankInfo(Long bankId) {
        BankOfficeRepository bankOfficeRepository = BankOfficeRepository.getInstance();
        AtmRepositoryBank bankAtmRepository = AtmRepositoryBank.getInstance();
        EmployeeRepository employeeRepository = EmployeeRepository.getInstance();
        UserRepository userRepository = UserRepository.getInstance();

        System.out.println(bankRepository.findById(bankId).getName());

        var bankOffices = bankOfficeRepository.findAll().stream()
                .filter(bankOffice ->
                        bankOffice.getBank().getId().compareTo(bankId) == 0
                )
                .toList();

        if (bankOffices.size() > 0) {
            System.out.println("Bank offices ");
            for (var bankOffice : bankOffices) {
                System.out.println(bankOffice);
            }
        }

        var bankAtms = bankAtmRepository.findAll().stream()
                .filter(bankAtm ->
                        bankAtm.getOffice().getBank().getId().compareTo(bankId) == 0
                )
                .toList();

        if (bankAtms.size() > 0) {
            System.out.println("Bank ATM ");
            for (var bankAtm : bankAtms) {
                System.out.println(bankAtm);
            }
        }

        var employees = employeeRepository.findAll().stream()
                .filter(employee ->
                        employee.getBankOffice().getBank().getId().compareTo(bankId) == 0
                )
                .toList();

        if (employees.size() > 0) {
            System.out.println("Bank employees ");
            for (var employee : employees) {
                System.out.println(employee);
            }
        }

        var users = userRepository.findAll().stream()
                .filter(user -> user.getBanks().stream()
                        .anyMatch(bank ->
                                bank.getId().compareTo(bankId) == 0
                        )
                )
                .toList();

        if (users.size() > 0) {
            System.out.println("Bank users ");
            for (var user : users) {
                System.out.println(user);
            }
        }

    }

    @Override
    public Long getLoan(Long userId, Double creditSum) throws FailedLoanException {
        AtmService atmService = AtmServiceImpl.getInstance();
        PaymentAccountService paymentAccountService = PaymentAccountServiceImpl.getInstance();
        EmployeeService employeeService = EmployeeServiceImpl.getInstance();
        BankOfficeService bankOfficeService = BankOfficeServiceImpl.getInstance();
        UserService userService = UserServiceImpl.getInstance();
        CreditAccountService creditAccountService = CreditAccountServiceImpl.getInstance();

        if (creditSum <= 0) {
            throw new ErrorSumException();
        }

        User user = userService.getObjectById(userId);
        var banks = bankRepository.findAll().stream().sorted(new BankComparator()).toList();

        for (int i = banks.size() - 1; i >= 0; i--) {
            if (user.getCreditRating() < MIN_CLIENT_RATING && banks.get(i).getBankRating() > TOP_BANK_RATING) {
                continue;
            }

            var offices = bankOfficeService.getAllBankOfficesByBankId(banks.get(i).getId());

            for (BankOffice office : offices) {
                if (!office.getGettingLoan() || office.getTotalMoney().compareTo(creditSum) < 0) {
                    continue;
                }

                var employee = employeeService.getEmployeeWithLoan(office.getId());
                if (employee == null) {
                    continue;
                }

                var atms = atmService.getAllBankAtmsByOffice(office.getId());
                for (BankAtm atm : atms) {
                    if (!atm.getAcceptingMoney() || atm.getTotalMoney().compareTo(creditSum) < 0) {
                        continue;
                    }

                    PaymentAccount paymentAccount = paymentAccountService.getPaymentAccount(banks.get(i), user);
                    int monthNumber = (int) (creditSum / user.getMonthlyIncome());
                    CreditAccount creditAccount = creditAccountService.createCreditAccount(banks.get(i), user,
                            paymentAccount, employee, creditSum, monthNumber);

                    atmService.withdrawMoney(atm.getId(), creditSum);

                    return creditAccountService.addObject(creditAccount).getId();
                }

            }
        }
        throw new FailedLoanException();
    }

    @Override
    public void exportAccounts(Long bankId, String filename) {
        Bank bank = bankRepository.findById(bankId);
        var paymentAccounts = PaymentAccountServiceImpl.getInstance().getAllPaymentAccounts(bank);
        var creditAccounts = CreditAccountServiceImpl.getInstance().getAllCreditAccounts(bank);

        AccountsRepository accountsRepository = new AccountsRepository(paymentAccounts, creditAccounts);

        try {
            File file = new File(filename);
            objectMapper.writeValue(file, accountsRepository);
        } catch (IOException e) {
            System.out.println("Something went wrong in IO stream.\n" + e.getMessage());
        }
    }

    @Override
    public void importAccounts(Long bankId, String filename) {
        File file = new File(filename);
        Bank bank = bankRepository.findById(bankId);
        try {
            AccountsRepository accountsRepository = objectMapper.readValue(file, AccountsRepository.class);
            var paymentAccounts = accountsRepository.paymentAccounts;
            var creditAccounts = accountsRepository.creditAccounts;

            paymentAccounts.forEach(paymentAccount -> paymentAccount.setBankName(bank.getName()));
            creditAccounts.forEach(creditAccount -> creditAccount.setBankName(bank.getName()));

            PaymentAccountService paymentAccountService = PaymentAccountServiceImpl.getInstance();
            CreditAccountService creditAccountService = CreditAccountServiceImpl.getInstance();

            List<PaymentAccount> newPaymentAccounts = new ArrayList<>();
            for (var paymentAccount : paymentAccounts) {
                paymentAccount.setBankName(bank.getName());
                newPaymentAccounts.add(paymentAccountService.addObject(paymentAccount));
            }
            for (var creditAccount : creditAccounts) {
                int index = paymentAccounts.indexOf(creditAccount.getPaymentAccount());
                if (index >= 0) {
                    creditAccount.setPaymentAccount(newPaymentAccounts.get(index));
                }
                creditAccountService.addObject(creditAccount);
            }
        } catch (IOException e) {
            System.out.println("Something went wrong in IO stream.\n" + e.getMessage());
        }
    }

    @Override
    public void transferAccounts(Long srcBankId, Long dstBankId) {
        var srcBank = bankRepository.findById(srcBankId);
        var dstBank = bankRepository.findById(dstBankId);

        if (srcBank == null || dstBank == null) {
            throw new IdNotFoundException();
        }

        var paymentAccounts = PaymentAccountServiceImpl.getInstance().getAllPaymentAccounts(srcBank);
        var creditAccounts = CreditAccountServiceImpl.getInstance().getAllCreditAccounts(srcBank);
        this.exportAccounts(srcBankId, TRANSFER_PATH);

        creditAccounts.forEach(paymentAccount -> CreditAccountRepository.getInstance().deleteById(paymentAccount.getId()));
        paymentAccounts.forEach(paymentAccount -> PaymentAccountRepository.getInstance().deleteById(paymentAccount.getId()));

        for (var paymentAccount : paymentAccounts) {
            User user = UserServiceImpl.getInstance().getObjectById(paymentAccount.getUser().getId());
            var banks = user.getBanks();
            banks.removeIf(bank -> bank.getName().equals(srcBank.getName()));
            user.setBanks(banks);
            UserServiceImpl.getInstance().updateObject(user);
        }

        this.importAccounts(dstBankId, TRANSFER_PATH);
    }

    private static class AccountsRepository {
        public List<PaymentAccount> paymentAccounts;
        public List<CreditAccount> creditAccounts;

        public AccountsRepository() {}

        public AccountsRepository(List<PaymentAccount> paymentAccounts, List<CreditAccount> creditAccounts) {
            this.paymentAccounts = paymentAccounts;
            this.creditAccounts = creditAccounts;
        }
    }
}
