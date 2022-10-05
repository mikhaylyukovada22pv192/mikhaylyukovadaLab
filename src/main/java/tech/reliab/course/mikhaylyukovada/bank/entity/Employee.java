package tech.reliab.course.mikhaylyukovada.bank.entity;

import java.time.LocalDate;

public class Employee {
    private Long id;
    private String name;
    private LocalDate birthDate;
    private String jobTitle;
    private String bankName;
    private Boolean isWorkingInOffice;
    private BankOffice bankOffice;
    private Boolean isPossibleGetLoan;
    private Double salary;

    public Employee(Long id, String name, LocalDate birthDate, String jobTitle, String bankName, Boolean isWorkingInOffice, BankOffice bankOffice, Boolean isPossibleGetLoan, Double salary) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.jobTitle = jobTitle;
        this.bankName = bankName;
        this.isWorkingInOffice = isWorkingInOffice;
        this.bankOffice = bankOffice;
        this.isPossibleGetLoan = isPossibleGetLoan;
        this.salary = salary;
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

    public String getJobTitle() {
        return jobTitle;
    }

    public String getBankName() {
        return bankName;
    }

    public Boolean getWorkingInOffice() {
        return isWorkingInOffice;
    }

    public BankOffice getBankOffice() {
        return bankOffice;
    }

    public Boolean getPossibleGetLoan() {
        return isPossibleGetLoan;
    }

    public Double getSalary() {
        return salary;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public void setWorkingInOffice(Boolean workingInOffice) {
        isWorkingInOffice = workingInOffice;
    }

    public void setBankOffice(BankOffice bankOffice) {
        this.bankOffice = bankOffice;
    }

    public void setPossibleGetLoan(Boolean possibleGetLoan) {
        isPossibleGetLoan = possibleGetLoan;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

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
