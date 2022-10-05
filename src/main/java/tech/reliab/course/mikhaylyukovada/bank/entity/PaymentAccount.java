package tech.reliab.course.mikhaylyukovada.bank.entity;

public class PaymentAccount {
    private Long id;
    private User user;
    private String bankName;
    private Double moneyAmount = 0.;

    public PaymentAccount(Long id, User user, String bankName) {
        this.id = id;
        this.user = user;
        this.bankName = bankName;
    }

    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public String getBankName() {
        return bankName;
    }

    public Double getMoneyAmount() {
        return moneyAmount;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public void setMoneyAmount(Double moneyAmount) {
        this.moneyAmount = moneyAmount;
    }

    public void clearPaymentAccount() {
        this.id = null;
        this.user = null;
        this.bankName = null;
        this.moneyAmount = null;
    }

    @Override
    public String toString() {
        return "PaymentAccount{" +
                "id='" + id + '\'' +
                ", user=" + user.getName() +
                ", bankName='" + bankName + '\'' +
                ", moneyAmount=" + moneyAmount +
                '}';
    }
}
