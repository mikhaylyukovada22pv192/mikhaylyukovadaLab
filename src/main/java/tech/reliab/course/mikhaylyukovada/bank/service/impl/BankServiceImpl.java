package tech.reliab.course.mikhaylyukovada.bank.service.impl;

import tech.reliab.course.mikhaylyukovada.bank.entity.Bank;
import tech.reliab.course.mikhaylyukovada.bank.repository.*;
import tech.reliab.course.mikhaylyukovada.bank.service.BankService;
import java.util.List;

/**
 * Реализация интерфейса для взаимодействия с банками
 */
public class BankServiceImpl implements BankService {
    private static BankServiceImpl INSTANCE;

    public static BankServiceImpl getInstance() {
        if (INSTANCE == null) { INSTANCE = new BankServiceImpl(); }

        return INSTANCE;
    }

    private final BankRepository bankRepository = BankRepository.getInstance();

    @Override
    public Bank addObject(Bank bank) {
        return bankRepository.add(bank);
    }

    @Override
    public Bank updateObject(Bank bank) {
        return bankRepository.update(bank);
    }

    @Override
    public boolean deleteObjectById(Long id) {
        return bankRepository.deleteById(id);
    }

    @Override
    public Bank getObjectById(Long id) {
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
                        .filter(bank ->
                                bank.getId().compareTo(bankId) == 0
                        )
                        .toList()
                        .size() > 0
                )
                .toList();

        if (users.size() > 0) {
            System.out.println("Bank users ");
            for (var user : users) {
                System.out.println(user);
            }
        }

    }
}
