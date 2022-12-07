package tech.reliab.course.mikhaylyukovada.bank;

import tech.reliab.course.mikhaylyukovada.bank.entity.*;
import tech.reliab.course.mikhaylyukovada.bank.service.*;
import tech.reliab.course.mikhaylyukovada.bank.service.impl.*;
import tech.reliab.course.mikhaylyukovada.bank.utils.BankEntityGenerator;


public class Main {

    static BankEntityGenerator generator = new BankEntityGenerator();

    public static void main(String[] args) {
        BankService bankService = BankServiceImpl.getInstance();
        UserService userService = UserServiceImpl.getInstance();

        generateBank(5, 3, 5, 5, 2);

        System.out.println("ALL BANKS \n");

        bankService.getAllObjects().forEach(bank -> {
                    bankService.outputBankInfo(bank.getId());
                    System.out.println();
                }
        );

        System.out.println("ALL CLIENTS \n");

        userService.getAllObjects().forEach(user -> {
                    userService.outputUserAccounts(user.getId());
                    System.out.println();
                }
        );

    }

    private static void generateBank(int numberOfBanks, int numberOfOffices, int numberOfEmployes, int numberOfUsers, int numberOfAccounts) {
        BankService bankService = BankServiceImpl.getInstance();
        BankOfficeService bankOfficeService = BankOfficeServiceImpl.getInstance();
        EmployeeService employeeService = EmployeeServiceImpl.getInstance();
        AtmService bankAtmService = AtmServiceImpl.getInstance();
        UserService userService = UserServiceImpl.getInstance();
        PaymentAccountService paymentAccountService = PaymentAccountServiceImpl.getInstance();
        CreditAccountService creditAccountService = CreditAccountServiceImpl.getInstance();

        for (int banksNumber = 0; banksNumber < numberOfBanks; banksNumber++) {
            Bank bank = bankService.addObject(generator.createBank());
            Employee employeeForAccount = null;

            for (int officesNumber = 0; officesNumber < numberOfOffices; officesNumber++) {
                BankOffice bankOffice = bankOfficeService.addObject(generator.createBankOffice(bank));

                for (int employeeNumber = 0; employeeNumber < numberOfEmployes; employeeNumber++) {
                    employeeForAccount = employeeService.addObject(generator.createEmployee(bankOffice));
                    bankAtmService.addObject(generator.createBankAtm(bankOffice, employeeForAccount));
                }

            }

            for (int usersNumber = 0; usersNumber < numberOfUsers; usersNumber++) {
                var user = userService.addObject(generator.createUser(bank));

                for (int accountsNumber = 0; accountsNumber < numberOfAccounts; accountsNumber++) {
                    PaymentAccount paymentAccount = paymentAccountService.addObject(generator.createPaymentAccount(bank, user));
                    creditAccountService.addObject(generator.createCreditAccount(bank, user, paymentAccount, employeeForAccount));
                }
            }
        }
    }

}
