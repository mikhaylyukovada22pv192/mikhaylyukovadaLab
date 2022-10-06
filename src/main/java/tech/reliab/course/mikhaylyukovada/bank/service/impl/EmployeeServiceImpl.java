package tech.reliab.course.mikhaylyukovada.bank.service.impl;

import tech.reliab.course.mikhaylyukovada.bank.entity.BankOffice;
import tech.reliab.course.mikhaylyukovada.bank.entity.Employee;
import tech.reliab.course.mikhaylyukovada.bank.service.EmployeeService;

import java.time.LocalDate;

public class EmployeeServiceImpl implements EmployeeService {

    private Employee employee = null;

    @Override
    public void create(Long id, String name, LocalDate birthDate, String jobTitle, String bankName, Boolean isWorkingInOffice, BankOffice bankOffice, Boolean isPossibleGetLoan, Double salary) {
        this.employee = new Employee(id, name, birthDate, jobTitle, bankName, isWorkingInOffice, bankOffice, isPossibleGetLoan, salary);
    }

    @Override
    public Employee read() {
        return employee;
    }

    @Override
    public void update(Employee employee) {
        this.employee = employee;
    }

    @Override
    public void delete() {
        this.employee = null;
    }
}
