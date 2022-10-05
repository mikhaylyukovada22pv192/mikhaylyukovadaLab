package tech.reliab.course.mikhaylyukovada.bank.entity;

import java.time.LocalDate;
import java.util.Random;

public class User {
    private Long id;
    private String name;
    private LocalDate birthDate;
    private String workPlace;
    private Double monthlyIncome;
    private Bank bank;
    private CreditAccount creditAccount = null;
    private PaymentAccount paymentAccount = null;
    private Double creditRating;

    public User(Long id, String name, LocalDate birthDate, String workPlace, Bank bank) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.workPlace = workPlace;
        this.bank = bank;

        Random rand = new Random();
        this.monthlyIncome = rand.nextDouble(10000) + 100;
        this.creditRating = this.monthlyIncome % 100;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public String getWorkPlace() {
        return workPlace;
    }

    public Double getMonthlyIncome() {
        return monthlyIncome;
    }

    public Bank getBank() {
        return bank;
    }

    public CreditAccount getCreditAccount() {
        return creditAccount;
    }

    public PaymentAccount getPaymentAccount() {
        return paymentAccount;
    }

    public Double getCreditRating() {
        return creditRating;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public void setWorkPlace(String workPlace) {
        this.workPlace = workPlace;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public void setCreditAccount(CreditAccount creditAccount) {
        this.creditAccount = creditAccount;
    }

    public void setPaymentAccount(PaymentAccount paymentAccount) {
        this.paymentAccount = paymentAccount;
    }

    public void clearUser() {
        this.id = null;
        this.name = null;
        this.birthDate = null;
        this.workPlace = null;
        this.monthlyIncome = null;
        this.bank = null;
        this.creditAccount = null;
        this.paymentAccount = null;
        this.creditRating = null;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", birthDate=" + birthDate +
                ", workPlace='" + workPlace + '\'' +
                ", monthlyIncome=" + monthlyIncome +
                ", bank=" + bank.getName() +
                ", creditAccount=" + creditAccount.toString() +
                ", paymentAccount=" + paymentAccount.toString() +
                ", creditRating=" + creditRating +
                '}';
    }
}
