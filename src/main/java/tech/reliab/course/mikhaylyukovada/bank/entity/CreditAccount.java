package tech.reliab.course.mikhaylyukovada.bank.entity;

import tech.reliab.course.mikhaylyukovada.bank.entity.common.BasicModel;
import java.time.LocalDate;

/**
 * Модель кредитного счета
 */
public class CreditAccount extends BasicModel {
    private User user;
    private String bankName;
    private LocalDate startDate;
    private LocalDate endDate;
    private Integer monthsNumber;
    private Double creditAmount;
    private Double monthlyPayment;
    private Double interestRate;
    private Employee employee;
    private PaymentAccount paymentAccount;

    public CreditAccount(){}

    /**
     * Конструктор для создания модели кредитного счета
     *
     * @param user пользователь кредитного счета
     * @param bankName название банка
     * @param startDate дата начала
     * @param monthsNumber кол-во месяцев
     * @param creditAmount сумма кредита
     * @param interestRate процентная ставка
     * @param employee сотрудник, выдавший кредит
     * @param paymentAccount платежный счет
     */
    public CreditAccount(User user, String bankName, LocalDate startDate, Integer monthsNumber, Double creditAmount, Double interestRate, Employee employee, PaymentAccount paymentAccount) {
        this.user = user;
        this.bankName = bankName;
        this.startDate = startDate;
        this.monthsNumber = monthsNumber;
        this.creditAmount = creditAmount;
        this.interestRate = interestRate;
        this.employee = employee;
        this.paymentAccount = paymentAccount;
    }

    /**
     * @return пользователя счета
     */
    public User getUser() {
        return user;
    }

    /**
     * @return название банка
     */
    public String getBankName() {
        return bankName;
    }

    /**
     * @return дата начала
     */
    public LocalDate getStartDate() {
        return startDate;
    }

    /**
     * @return дата окончания
     */
    public LocalDate getEndDate() {
        return endDate;
    }

    /**
     * @return кол-во месяцев
     */
    public Integer getMonthsNumber() {
        return monthsNumber;
    }

    /**
     * @return сумма кредита
     */
    public Double getCreditAmount() {
        return creditAmount;
    }

    /**
     * @return кол-во месяцев
     */
    public Double getMonthlyPayment() {
        return monthlyPayment;
    }

    /**
     * @return процентная ставка
     */
    public Double getInterestRate() {
        return interestRate;
    }

    /**
     * @return сотрудник, выдавший кредит
     */
    public Employee getEmployee() {
        return employee;
    }

    /**
     * @return платежный счет
     */
    public PaymentAccount getPaymentAccount() {
        return paymentAccount;
    }

    /**
     * Задает пользователя счета
     *
     * @param user пользователь
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * Задает название банка
     *
     * @param bankName название
     */
    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    /**
     * Задает дату начала кредита
     *
     * @param startDate дата
     */
    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    /**
     * Задает дату окончания кредита
     *
     * @param endDate дата
     */
    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    /**
     * Задает кол-во месяцев
     *
     * @param monthsNumber кол-во
     */
    public void setMonthsNumber(Integer monthsNumber) {
        this.monthsNumber = monthsNumber;
    }

    /**
     * Задает сумму кредита
     *
     * @param creditAmount сумма
     */
    public void setCreditAmount(Double creditAmount) {
        this.creditAmount = creditAmount;
    }

    /**
     * Задает ежемесячный платеж
     *
     * @param monthlyPayment платеж
     */
    public void setMonthlyPayment(Double monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
    }

    /**
     * Задает процентную ставку
     *
     * @param interestRate ставка
     */
    public void setInterestRate(Double interestRate) {
        this.interestRate = interestRate;
    }

    /**
     * Задает сотрудника, выдавшего кредит
     *
     * @param employee сотрудник
     */
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    /**
     * Задет платежный счет
     *
     * @param paymentAccount счет
     */
    public void setPaymentAccount(PaymentAccount paymentAccount) {
        this.paymentAccount = paymentAccount;
    }

    /**
     * Отчищает кредитный счет
     */
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
                ", paymentAccount='" + paymentAccount.getBankName() + '\'' +
                '}';
    }
}
