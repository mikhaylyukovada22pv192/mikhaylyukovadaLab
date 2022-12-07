package tech.reliab.course.mikhaylyukovada.bank;

import tech.reliab.course.mikhaylyukovada.bank.entity.*;
import tech.reliab.course.mikhaylyukovada.bank.service.*;
import tech.reliab.course.mikhaylyukovada.bank.service.impl.*;
import tech.reliab.course.mikhaylyukovada.bank.utils.CreatingUtils;

import java.util.Random;


public class Main {

    static BankEntityGenerator generator = new BankEntityGenerator();
    private static final Random RANDOM = new Random();
    private static final double MIN_CREDIT_SUM = 1000;
    private static final double CREDIT_SUM = 1000000;

    public static void main(String[] args) {
        BankService bankService = BankServiceImpl.getInstance();
        UserService userService = UserServiceImpl.getInstance();
        Scanner input = new Scanner(System.in);

        generateBank(5, 3, 5, 5, 2);

        System.out.println("\nAll banks name:\n");
        bankService.getAllObjects().forEach(bank -> System.out.println(bank.getName()));

        String bankName = null;
        while(bankName == null || bankName.isEmpty()) {
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
        while(userName == null || userName.isEmpty()) {
            System.out.println("\nInput user name to get more info:");
            userName = input.nextLine();
        }

        try {
            String finalUserName = bankName;
            var requiredUser = userService.getAllObjects().stream().filter(bank ->
                    Objects.equals(bank.getName(), finalUserName)
            ).findFirst().get();

            userService.outputUserAccounts(requiredUser.getId());
            System.out.println();
        } catch (NoSuchElementException e) {
            System.out.println("No such user. " + e.getMessage());
        }
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

    /*
    for (int userNumber = 0; userNumber < userService.getAllObjects().size(); userNumber++) {
            var userId = userService.getAllObjects().get(userNumber).getId();
            System.out.println("For user with id = " + userId);
            try {
                var creditId = bankService.getLoan(userId, RANDOM.nextDouble() * CREDIT_SUM + MIN_CREDIT_SUM);
                System.out.println("Successfully get a loan with id = " + creditId);
            } catch (FailedLoanException failedLoanException) {
                System.out.println("Failed to get a loan");
            }
            System.out.println();
        }
    */

}
