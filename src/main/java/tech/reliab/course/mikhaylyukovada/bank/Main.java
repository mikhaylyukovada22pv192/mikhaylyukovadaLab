package tech.reliab.course.mikhaylyukovada.bank;

import tech.reliab.course.mikhaylyukovada.bank.entity.*;
import tech.reliab.course.mikhaylyukovada.bank.service.*;
import tech.reliab.course.mikhaylyukovada.bank.service.impl.*;
import tech.reliab.course.mikhaylyukovada.bank.utils.CreatingUtils;


public class Main {

    static CreatingUtils utils = new CreatingUtils();

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

        for (int banksNumber = 0; banksNumber < 5; banksNumber++) {
            bankService.outputBankInfo(bankService.getAllObjects().get(banksNumber).getId());
            System.out.println();
        }

        System.out.println("FIVE CLIENTS \n");

        for (int number = 0; number < 5; number++) {
            userService.outputUserAccounts(userService.getAllObjects().get(number).getId());
            System.out.println();
        }
    }

}
