package tech.reliab.course.mikhaylyukovada.bank.entity;

import java.time.LocalDate;

public class CreditAccount {
    private Long id;
    private User user;
    private String bankName;
    private LocalDate startDate;
    private LocalDate endDate;
    private Integer monthsNumber;
    private Double creditAmount;
    private Double monthlyPayment;
    private Double interestRate;
    private Employee employee;
    private String paymentAccount;

    public CreditAccount(Long id, User user, String bankName, LocalDate startDate, LocalDate endDate, Integer monthsNumber, Double creditAmount, Double monthlyPayment, Double interestRate, Employee employee, String paymentAccount) {
        this.id = id;
        this.user = user;
        this.bankName = bankName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.monthsNumber = monthsNumber;
        this.creditAmount = creditAmount;
        this.monthlyPayment = monthlyPayment;
        this.interestRate = interestRate;
        this.employee = employee;
        this.paymentAccount = paymentAccount;
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

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public Integer getMonthsNumber() {
        return monthsNumber;
    }

    public Double getCreditAmount() {
        return creditAmount;
    }

    public Double getMonthlyPayment() {
        return monthlyPayment;
    }

    public Double getInterestRate() {
        return interestRate;
    }

    public Employee getEmployee() {
        return employee;
    }

    public String getPaymentAccount() {
        return paymentAccount;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public void setMonthsNumber(Integer monthsNumber) {
        this.monthsNumber = monthsNumber;
    }

    public void setCreditAmount(Double creditAmount) {
        this.creditAmount = creditAmount;
    }

    public void setMonthlyPayment(Double monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
    }

    public void setInterestRate(Double interestRate) {
        this.interestRate = interestRate;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public void setPaymentAccount(String paymentAccount) {
        this.paymentAccount = paymentAccount;
    }

    public void clearCreditAccount() {
        this.id = null;
        this.user = null;
        this.bankName = null;
        this.startDate = null;
        this.endDate = null;
        this.monthsNumber = null;
        this.creditAmount = null;
        this.monthlyPayment = null;
        this.interestRate = null;
        this.employee = null;
        this.paymentAccount = null;
    }

    @Override
    public String toString() {
        return "CreditAccount{" +
                "id='" + id + '\'' +
                ", user=" + user.getName() +
                ", bankName='" + bankName + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", monthsNumber=" + monthsNumber +
                ", creditAmount=" + creditAmount +
                ", monthlyPayment=" + monthlyPayment +
                ", interestRate=" + interestRate +
                ", employee=" + employee.getName() +
                ", paymentAccount='" + paymentAccount + '\'' +
                '}';
    }
}
