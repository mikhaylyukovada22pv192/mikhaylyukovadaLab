package tech.reliab.course.mikhaylyukovada.bank.entity;

import tech.reliab.course.mikhaylyukovada.bank.entity.common.BankObject;

/**
 * Модель банка
 */
public class Bank extends BankObject {

    private String name;
    private Integer officesNumber = 0;
    private Integer atmsNumber = 0;
    private Integer employeesNumber = 0;
    private Integer clientsNumber = 0;
    private Integer bankRating;
    private Double totalMoney;
    private Double interestRate;

    public Bank() {}

    /**
     * Конструктор для создания модели банка
     *
     * @param name название
     */
    public Bank(String name, Integer rating, Double money, Double interestRate) {
        this.name = name;
        this.bankRating = rating;
        this.totalMoney = money;
        this.interestRate = interestRate;
    }

    protected Bank(Bank bank) {
        super(bank.getId());
        this.name = bank.getName();
        this.officesNumber = bank.getOfficesNumber();
        this.atmsNumber = bank.getAtmsNumber();
        this.employeesNumber = bank.getEmployeesNumber();
        this.clientsNumber = bank.getClientsNumber();
        this.bankRating = bank.getBankRating();
        this.totalMoney = bank.getTotalMoney();
        this.interestRate = bank.getInterestRate();
    }

    /**
     * @return название банка
     */
    public String getName() {
        return name;
    }

    /**
     * @return количество офисов
     */
    public Integer getOfficesNumber() {
        return officesNumber;
    }

    /**
     * @return количество банкоматов
     */
    public Integer getAtmsNumber() {
        return atmsNumber;
    }

    /**
     * @return количество сотрудников
     */
    public Integer getEmployeesNumber() {
        return employeesNumber;
    }

    /**
     * @return количество клиентов
     */
    public Integer getClientsNumber() {
        return clientsNumber;
    }

    /**
     * @return рейтинг банка
     */
    public Integer getBankRating() {
        return bankRating;
    }

    /**
     * @return количество денег в банке
     */
    public Double getTotalMoney() {
        return totalMoney;
    }

    /**
     * @return процентную ставку
     */
    public Double getInterestRate() {
        return interestRate;
    }

    /**
     * Задает название банка
     *
     * @param name название банка
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Добавляет офис
     */
    public void setOfficesNumber(int number) {
        this.officesNumber = number;
    }

    /**
     * Добавляет АТМ
     */
    public void setAtmsNumber(int number) {
        this.atmsNumber = number;
    }

    /**
     * Добавляет работника
     */
    public void setEmployeesNumber(int number) {
        this.employeesNumber = number;
    }

    /**
     * Добавляет клиента
     */
    public void setClientsNumber(int number) {
        this.clientsNumber = number;
    }

    /**
     * Отчищает данные банка
     */
    public void clearBank() {
        this.id = null;
        this.name = null;
        this.officesNumber = null;
        this.atmsNumber = null;
        this.employeesNumber = null;
        this.clientsNumber = null;
        this.bankRating = null;
        this.totalMoney = null;
        this.interestRate = null;
    }

    @Override
    public String toString() {
        return "Bank{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", officesNumber=" + officesNumber +
                ", atmsNumber=" + atmsNumber +
                ", employeesNumber=" + employeesNumber +
                ", clientsNumber=" + clientsNumber +
                ", bankRating=" + bankRating +
                ", totalMoney=" + totalMoney +
                ", interestRate=" + interestRate +
                '}';
    }
}
