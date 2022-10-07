package tech.reliab.course.mikhaylyukovada.bank.entity;

import java.util.Random;

/**
 * Модель банка
 */
public class Bank {
    private Long id;
    private String name;
    private Integer officesNumber = 0;
    private Integer atmsNumber = 0;
    private Integer employeesNumber = 0;
    private Integer clientsNumber = 0;
    private Integer bankRating;
    private Double totalMoney;
    private Double interestRate;

    /**
     * Конструктор для создания модели банка
     *
     * @param id id банка
     * @param name название
     */
    public Bank(Long id, String name) {
        this.id = id;
        this.name = name;

        Random rand = new Random();
        this.bankRating = rand.nextInt(100);
        this.totalMoney = rand.nextDouble(1000000);
        this.interestRate = rand.nextDouble(20 - this.bankRating / 10.);
    }

    protected Bank(Bank bank) {
        this.id = bank.getId();
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
     * @return id банка
     */
    public Long getId() {
        return id;
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
    public void addOffice() {
        this.officesNumber++;
    }

    /**
     * Добавляет АТМ
     */
    public void addAtm() {
        this.atmsNumber++;
    }

    /**
     * Добавляет работника
     */
    public void addEmployee() {
        this.employeesNumber++;
    }

    /**
     * Добавляет клиента
     */
    public void addClient() {
        this.clientsNumber++;
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
