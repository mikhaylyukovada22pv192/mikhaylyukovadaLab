package tech.reliab.course.mikhaylyukovada.bank;

import tech.reliab.course.mikhaylyukovada.bank.service.*;
import tech.reliab.course.mikhaylyukovada.bank.service.impl.*;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        BankService bank = new BankServiceImpl();
        bank.create(
                1L,
                "Sberbank"
        );

        BankOfficeService bankOffice = new BankOfficeServiceImpl();
        bank.addOffice();
        bankOffice.create(
                2L,
                "Sberbank office",
                "Moscow, Lenin's street 12",
                true,
                true,
                true,
                true,
                true,
                120.
        );

        EmployeeService employee = new EmployeeServiceImpl();
        bank.addEmployee();
        employee.create(
                3L,
                "Alex Mironov",
                LocalDate.of(1990, 8, 11),
                "Director",
                "Sberbank",
                true,
                bankOffice.read(),
                true,
                10000.
        );

        AtmService bankAtm = new AtmServiceImpl();
        bank.addAtm();
        bankOffice.addAtm();
        bankAtm.create(
                bankOffice.read(),
                4L,
                "Sberbank ATM",
                true,
                "Moscow, Lenin's street 12",
                employee.read(),
                true,
                true,
                250.
        );

        UserService user = new UserServiceImpl();
        bank.addClient();
        user.create(
                5L,
                "Max Afdeev",
                LocalDate.of(1995, 1, 10),
                "VK",
                bank.read()
        );

        CreditAccountService creditAccount = new CreditAccountServiceImpl();
        creditAccount.create(
                6L,
                user.read(),
                "Sberbank",
                LocalDate.of(2022, 2, 20),
                24,
                500000.,
                bank.read().getInterestRate(),
                employee.read(),
                "123rt4856"
        );

        PaymentAccountService paymentAccount = new PaymentAccountServiceImpl();
        paymentAccount.create(
                7L,
                user.read(),
                "Sberbank"
        );

        user.read().setCreditAccount(creditAccount.read());
        user.read().setPaymentAccount(paymentAccount.read());

        System.out.println(bank.read() + "\n" + bankOffice.read() + "\n" + employee.read() + "\n" + bankAtm.read() + "\n" + user.read() + "\n" + creditAccount.read() + "\n" + paymentAccount.read());
    }
}
