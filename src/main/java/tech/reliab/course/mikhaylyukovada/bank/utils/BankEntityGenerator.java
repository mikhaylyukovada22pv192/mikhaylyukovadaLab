package tech.reliab.course.mikhaylyukovada.bank.utils;

import tech.reliab.course.mikhaylyukovada.bank.entity.*;
import java.time.LocalDate;
import java.util.Random;

public class BankEntityGenerator {
    private static final Random random = new Random();
    private static long number = 0L;

    public Bank createBank() {
        int bankRating = random.nextInt(100);
        double totalMoney = random.nextDouble(1000000);
        double interestRate = random.nextDouble(20 - bankRating / 10.);

        return new Bank(String.format("Bank number %d", number++), bankRating, totalMoney, interestRate);
    }

    public BankOffice createBankOffice(Bank bank) {
        return new BankOffice(String.format("Office number %d", number), String.format("Address number %d", number++), bank, true, true,
                true, true, true, bank.getTotalMoney(), 42.0d);
    }

    public Employee createEmployee(BankOffice bankOffice) {
        return new Employee(String.format("Employee number %d", number++), LocalDate.now(), "doing some stuff", true, bankOffice,
                true, 900000d);
    }

    public BankAtm createBankAtm(BankOffice bankOffice, Employee employee) {
        return new BankAtm(String.format("Atm number %d", number++),  bankOffice, true,"somewhere on Earth",
                employee, true, true, bankOffice.getTotalMoney(), 112d);
    }

    public User createUser(Bank bank) {
        double monthlyIncome = random.nextDouble(10000) + 100;
        double creditRating = monthlyIncome % 100;

        return new User(String.format("User number %d", number++), LocalDate.now(), "Chair", bank,
                monthlyIncome, creditRating);
    }

    public PaymentAccount createPaymentAccount(Bank bank, User user) {
        return new PaymentAccount(user, bank.getName());
    }

    public CreditAccount createCreditAccount(Bank bank, User user, PaymentAccount paymentAccount, Employee employee) {
        return new CreditAccount(user, bank.getName(), LocalDate.now(), 12, 78000d,
                bank.getInterestRate(), employee, paymentAccount);
    }
}
