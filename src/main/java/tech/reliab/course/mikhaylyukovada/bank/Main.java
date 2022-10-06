package tech.reliab.course.mikhaylyukovada.bank;

import tech.reliab.course.mikhaylyukovada.bank.entity.*;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank(
                1L,
                "Sberbank"
        );
        BankOffice bankOffice = new BankOffice(bank,
                2L,
                "Sberbank office",
                "Moscow, Lenin's street 12",
                true,
                true,
                3,
                true,
                true,
                true,
                120.
        );
        Employee employee = new Employee(
                3L,
                "Alex Mironov",
                LocalDate.of(1990, 8, 11),
                "Director",
                "Sberbank",
                true,
                bankOffice,
                true,
                10000.
        );
        BankAtm bankAtm = new BankAtm(bank,
                4L,
                "Sberbank ATM",
                true,
                "Moscow, Lenin's street 12",
                employee,
                true,
                true,
                250.
        );
        User user = new User(
                5L,
                "Max Afdeev",
                LocalDate.of(1995, 1, 10),
                "VK",
                bank
        );
        CreditAccount creditAccount = new CreditAccount(
                6L,
                user,
                "Sberbank",
                LocalDate.of(2022, 2, 20),
                LocalDate.of(2024, 2, 20),
                24,
                500000.,
                2500.,
                bank.getInterestRate(),
                employee,
                "123rt4856"
        );

        PaymentAccount paymentAccount = new PaymentAccount(
                7L,
                user,
                "Sberbank"
        );

        user.setCreditAccount(creditAccount);
        user.setPaymentAccount(paymentAccount);

        System.out.println(bank + "\n" + bankOffice + "\n" + employee + "\n" + bankAtm + "\n" + user + "\n" + creditAccount + "\n" + paymentAccount);
    }
}
