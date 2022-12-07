package tech.reliab.course.mikhaylyukovada.bank.entity;

import tech.reliab.course.mikhaylyukovada.bank.entity.common.BasicModel;

/**
 * Модель платежного счета
 */
public class PaymentAccount extends BasicModel {
    private User user;
    private String bankName;
    private Double moneyAmount = 0.;

    /**
     * Коснтруктор для создания модель платежного счета
     *
     * @param user пользователь счета
     * @param bankName название банка
     */
    public PaymentAccount(User user, String bankName) {
        this.user = user;
        this.bankName = bankName;
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
     * @return кол-во денег на счете
     */
    public Double getMoneyAmount() {
        return moneyAmount;
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
     * Задает кол-во денег на счету
     *
     * @param moneyAmount кол-во денег
     */
    public void setMoneyAmount(Double moneyAmount) {
        this.moneyAmount = moneyAmount;
    }

    /**
     * Отчищает платежный счете
     */
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
