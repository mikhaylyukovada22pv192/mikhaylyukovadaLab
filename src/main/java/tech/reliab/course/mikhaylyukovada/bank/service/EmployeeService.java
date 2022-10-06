package tech.reliab.course.mikhaylyukovada.bank.service;

import tech.reliab.course.mikhaylyukovada.bank.entity.BankOffice;
import tech.reliab.course.mikhaylyukovada.bank.entity.Employee;

import java.time.LocalDate;

public interface EmployeeService {

    void create(Long id, String name, LocalDate birthDate, String jobTitle, String bankName, Boolean isWorkingInOffice, BankOffice bankOffice, Boolean isPossibleGetLoan, Double salary);

    Employee read();

    void update(Employee employee);

    void delete();
}
