package tech.reliab.course.mikhaylyukovada.bank.service.impl;

import tech.reliab.course.mikhaylyukovada.bank.entity.*;
import tech.reliab.course.mikhaylyukovada.bank.exceptions.FailedLoanException;
import tech.reliab.course.mikhaylyukovada.bank.exceptions.ErrorSumException;
import tech.reliab.course.mikhaylyukovada.bank.exceptions.IdNotFoundException;
import tech.reliab.course.mikhaylyukovada.bank.exceptions.WrongNameException;
import tech.reliab.course.mikhaylyukovada.bank.repository.*;
import tech.reliab.course.mikhaylyukovada.bank.service.*;
import tech.reliab.course.mikhaylyukovada.bank.utils.BankComparator;

import java.util.List;

/**
 * Реализация интерфейса для взаимодействия с банками
 */
public class BankServiceImpl implements BankService {
    private static BankServiceImpl INSTANCE;

    public static BankServiceImpl getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new BankServiceImpl();
        }

        return INSTANCE;
    }

    private final BankRepository bankRepository = BankRepository.getInstance();

    private static final double MAX_INTEREST_RATE = 20.d;
    private static final int MAX_MONEY = 1_000_000;
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
                if (employee == null) { continue; }

                var atms = atmService.getAllBankAtmsByOffice(office.getId());
                for (BankAtm atm : atms) {
                    if (!atm.getAcceptingMoney() || atm.getTotalMoney().compareTo(creditSum) < 0) { continue; }

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
}
