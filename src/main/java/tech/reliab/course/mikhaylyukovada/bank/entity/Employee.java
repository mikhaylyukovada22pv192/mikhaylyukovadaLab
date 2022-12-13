package tech.reliab.course.mikhaylyukovada.bank.entity;

import tech.reliab.course.mikhaylyukovada.bank.entity.common.Person;
import java.time.LocalDate;

/**
 * Модель сотрудника
 */
public class Employee extends Person {
    private String jobTitle;
    private String bankName;
    private Boolean isWorkingInOffice;
    private BankOffice bankOffice;
    private Boolean isPossibleGetLoan;
    private Double salary;

    /**
     * Конструктор для создания модели сотрудника
     *
     * @param name имя сотрудника
     * @param birthDate дата рождения
     * @param jobTitle должность
     * @param isWorkingInOffice работает ли в офисе
     * @param bankOffice офис, в котором работает
     * @param isPossibleGetLoan может ли выдать кредит
     * @param salary зарплата
     */
    public Employee(String name, LocalDate birthDate, String jobTitle, Boolean isWorkingInOffice, BankOffice bankOffice, Boolean isPossibleGetLoan, Double salary) {
        super(name, birthDate);
        this.jobTitle = jobTitle;
        this.isWorkingInOffice = isWorkingInOffice;
        this.bankOffice = bankOffice;
        this.isPossibleGetLoan = isPossibleGetLoan;
        this.salary = salary;
    }

    /**
     * @return должность
     */
    public String getJobTitle() {
        return jobTitle;
    }

    /**
     * @return название банка
     */
    public String getBankName() {
        return bankName;
    }

    /**
     * @return работает ли в офисе
     */
    public Boolean getWorkingInOffice() {
        return isWorkingInOffice;
    }

    /**
     * @return название офиса
     */
    public BankOffice getBankOffice() {
        return bankOffice;
    }

    /**
     * @return выдает ли кредиты
     */
    public Boolean getPossibleGetLoan() {
        return isPossibleGetLoan;
    }

    /**
     * @return зарпалата сотрудника
     */
    public Double getSalary() {
        return salary;
    }

    /**
     * Задает должность сотрудника
     *
     * @param jobTitle должность
     */
    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
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
     * Задает в каком режиме работает сотрудник
     *
     * @param workingInOffice работает ли в офисе
     */
    public void setWorkingInOffice(Boolean workingInOffice) {
        isWorkingInOffice = workingInOffice;
    }

    /**
     * Задает офис, в котором работает сотрудник
     *
     * @param bankOffice офис
     */
    public void setBankOffice(BankOffice bankOffice) {
        this.bankOffice = bankOffice;
    }

    /**
     * Задает возможожность выдать кредит
     *
     * @param possibleGetLoan выдает ли сотрудник кредит
     */
    public void setPossibleGetLoan(Boolean possibleGetLoan) {
        isPossibleGetLoan = possibleGetLoan;
    }

    /**
     * Задает зарплату сотрудника
     *
     * @param salary зарплата
     */
    public void setSalary(Double salary) {
        this.salary = salary;
    }

    /**
     * Отчищает данные о сотруднике
     */
    public void clearEmployee() {
        this.id = null;
        this.name = null;
        this.birthDate = null;
        this.jobTitle = null;
        this.bankName = null;
        this.isWorkingInOffice = null;
        this.bankOffice = null;
        this.isPossibleGetLoan = null;
        this.salary = null;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", birthDate=" + birthDate +
                ", jobTitle='" + jobTitle + '\'' +
                ", bankName='" + bankName + '\'' +
                ", isWorkingInOffice=" + isWorkingInOffice +
                ", bankOffice=" + bankOffice +
                ", isPossibleGetLoan=" + isPossibleGetLoan +
                ", salary=" + salary +
                '}';
    }
}
