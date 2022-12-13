package tech.reliab.course.mikhaylyukovada.bank;

import tech.reliab.course.mikhaylyukovada.bank.entity.*;
import tech.reliab.course.mikhaylyukovada.bank.exceptions.FailedLoanException;
import tech.reliab.course.mikhaylyukovada.bank.service.*;
import tech.reliab.course.mikhaylyukovada.bank.service.impl.*;
import tech.reliab.course.mikhaylyukovada.bank.utils.BankEntityGenerator;

import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class Main {

    static BankEntityGenerator generator = new BankEntityGenerator();
    private static final Random RANDOM = new Random();
    private static final double MIN_CREDIT_SUM = 1000;
    private static final double CREDIT_SUM = 1000000;

    public static void main(String[] args) {
        generateBank(5, 3, 5, 5, 2);
        workWithTxtFile();
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

    // Функция для ЛР 2
    private static void outputBankAndClient() {
        BankService bankService = BankServiceImpl.getInstance();
        UserService userService = UserServiceImpl.getInstance();
        Scanner input = new Scanner(System.in);

        System.out.println("\nAll banks name:\n");
        bankService.getAllObjects().forEach(bank -> System.out.println(bank.getName()));

        String bankName = null;
        while (bankName == null || bankName.isEmpty()) {
            System.out.println("\nInput bank name to get more info:");
            bankName = input.nextLine();
        }

        try {
            String finalBankName = bankName;
            var requiredBank = bankService.getAllObjects().stream().filter(bank ->
                    Objects.equals(bank.getName(), finalBankName)
            ).findFirst().get();

            bankService.outputBankInfo(requiredBank.getId());
            System.out.println();
        } catch (NoSuchElementException e) {
            System.out.println("No such bank. " + e.getMessage());
        }

        System.out.println("\nAll clients name:\n");
        userService.getAllObjects().forEach(user -> System.out.println(user.getName()));

        String userName = null;
        while (userName == null || userName.isEmpty()) {
            System.out.println("\nInput user name to get more info:");
            userName = input.nextLine();
        }

        try {
            String finalUserName = userName;
            var requiredUser = userService.getAllObjects().stream().filter(user ->
                    Objects.equals(user.getName(), finalUserName)
            ).findFirst().get();

            userService.outputUserAccounts(requiredUser.getId());
            System.out.println();
        } catch (NoSuchElementException e) {
            System.out.println("No such user. " + e.getMessage());
        }
    }

    // Функция для ЛР 3
    private static void getLoanForUser() {
        BankService bankService = BankServiceImpl.getInstance();
        UserService userService = UserServiceImpl.getInstance();
        Scanner input = new Scanner(System.in);

        System.out.println("\nAll clients name:\n");
        userService.getAllObjects().forEach(user -> System.out.println(user.getName()));

        String userName = null;
        while (userName == null || userName.isEmpty()) {
            System.out.println("\nInput user name to get a loan for him:");
            userName = input.nextLine();
        }

        try {
            String finalUserName = userName;
            var requiredUser = userService.getAllObjects().stream().filter(bank ->
                    Objects.equals(bank.getName(), finalUserName)
            ).findFirst().get();

            try {
                var creditId = bankService.getLoan(requiredUser.getId(), RANDOM.nextDouble() * CREDIT_SUM + MIN_CREDIT_SUM);
                System.out.println("Successfully get a loan with id = " + creditId);
            } catch (FailedLoanException failedLoanException) {
                System.out.println("Failed to get a loan");
            }
        } catch (NoSuchElementException e) {
            System.out.println("No such user. " + e.getMessage());
        }
    }

    // Функция для ЛР 4
    private static void workWithTxtFile() {
        BankService bankService = BankServiceImpl.getInstance();
        UserService userService = UserServiceImpl.getInstance();

        var userId = userService.getAllObjects().get(0).getId();

        bankService.exportAccounts(bankService.getAllObjects().get(0).getId(), "/Users/darmi/LR4/accounts.txt");
        bankService.transferAccounts(bankService.getAllObjects().get(0).getId(), bankService.getAllObjects().get(1).getId());

        userService.outputUserAccounts(userId);
    }
}
