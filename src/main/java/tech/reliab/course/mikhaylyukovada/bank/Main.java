package tech.reliab.course.mikhaylyukovada.bank;

import tech.reliab.course.mikhaylyukovada.bank.entity.*;
import tech.reliab.course.mikhaylyukovada.bank.exceptions.FailedLoanException;
import tech.reliab.course.mikhaylyukovada.bank.service.*;
import tech.reliab.course.mikhaylyukovada.bank.service.impl.*;
import tech.reliab.course.mikhaylyukovada.bank.utils.CreatingUtils;
import java.util.Random;

public class Main {

    static CreatingUtils utils = new CreatingUtils();

    private static final Random RANDOM = new Random();
    private static final double MIN_CREDIT_SUM = 1000;
    private static final double CREDIT_SUM = 1000000;

    public static void main(String[] args) {
        BankService bankService = BankServiceImpl.getInstance();
        BankOfficeService bankOfficeService = BankOfficeServiceImpl.getInstance();
        EmployeeService employeeService = EmployeeServiceImpl.getInstance();
        AtmService bankAtmService = AtmServiceImpl.getInstance();
        UserService userService = UserServiceImpl.getInstance();
        PaymentAccountService paymentAccountService = PaymentAccountServiceImpl.getInstance();
        CreditAccountService creditAccountService = CreditAccountServiceImpl.getInstance();

        for (int banksNumber = 0; banksNumber < 5; banksNumber++) {
            Bank bank = bankService.addObject(utils.createBank());
            Employee employeeForAccount = null;

            for (int officesNumber = 0; officesNumber < 3; officesNumber++) {
                BankOffice bankOffice = bankOfficeService.addObject(utils.createBankOffice(bank));

                for (int employeeNumber = 0; employeeNumber < 5; employeeNumber++) {
                    employeeForAccount = employeeService.addObject(utils.createEmployee(bankOffice));
                    bankAtmService.addObject(utils.createBankAtm(bankOffice, employeeForAccount));
                }

            }

            for (int usersNumber = 0; usersNumber < 5; usersNumber++) {
                var user = userService.addObject(utils.createUser(bank));

                for (int accountsNumber = 0; accountsNumber < 2; accountsNumber++) {
                    PaymentAccount paymentAccount = paymentAccountService.addObject(utils.createPaymentAccount(bank, user));
                    creditAccountService.addObject(utils.createCreditAccount(bank, user, paymentAccount, employeeForAccount));
                }
            }
        }

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
    }

}
