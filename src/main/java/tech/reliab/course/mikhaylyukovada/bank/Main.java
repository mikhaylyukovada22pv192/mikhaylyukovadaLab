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
        getLoanForUser();
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

        System.out.println("\nAll clients:\n");
        userService.getAllObjects().forEach(user -> System.out.println(user.toString()));

        String userName = null;
        while (userName == null || userName.isEmpty()) {
            System.out.println("\nInput user name:");
            userName = input.nextLine();
        }

        System.out.println("\nAll banks:\n");
        bankService.getAllObjects().forEach(bank -> System.out.println(bank.toString()));

        String bankName = null;
        while (bankName == null || bankName.isEmpty()) {
            System.out.println("\nInput bank name:");
            bankName = input.nextLine();
        }

        String creditSum = null;
        while (creditSum == null || creditSum.isEmpty()) {
            System.out.println("\nInput credit sum:");
            creditSum = input.nextLine();
        }

        User requiredUser = null;
        Bank requiredBank = null;

        try {
            String finalUserName = userName;
            requiredUser = userService.getAllObjects().stream().filter(user ->
                    Objects.equals(user.getName(), finalUserName)
            ).findFirst().get();
        } catch (NoSuchElementException e) {
            System.out.println("No such user. " + e.getMessage());
        }

        try {
            String finalBankName = bankName;
            requiredBank = bankService.getAllObjects().stream().filter(bank ->
                    Objects.equals(bank.getName(), finalBankName)
            ).findFirst().get();
        } catch (NoSuchElementException e) {
            System.out.println("No such bank. " + e.getMessage());
        }

        if(requiredUser != null &&  requiredBank != null) {
            try {
                double finalCreditSum = Double.parseDouble(creditSum);

                if (finalCreditSum > MIN_CREDIT_SUM) {
                    try {
                        var creditId = bankService.getLoanInCurrentBank(requiredUser.getId(), requiredBank.getId(), finalCreditSum);
                        System.out.println("Successfully get a loan with id = " + creditId);
                    } catch (FailedLoanException failedLoanException) {
                        System.out.println("Failed to get a loan. " + failedLoanException.getMessage());
                    }
                } else {
                    System.out.println("Error. Min credit sum = 10 000");
                }
            } catch (NumberFormatException e) {
                System.out.println("Wrong credit sum. " + e.getMessage());
            }
        }
    }
}
