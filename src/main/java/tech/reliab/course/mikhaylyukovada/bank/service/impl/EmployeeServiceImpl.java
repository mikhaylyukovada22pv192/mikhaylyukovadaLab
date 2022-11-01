package tech.reliab.course.mikhaylyukovada.bank.service.impl;

import tech.reliab.course.mikhaylyukovada.bank.entity.BankOffice;
import tech.reliab.course.mikhaylyukovada.bank.entity.Employee;
import tech.reliab.course.mikhaylyukovada.bank.service.BankOfficeService;
import tech.reliab.course.mikhaylyukovada.bank.service.BankService;
import tech.reliab.course.mikhaylyukovada.bank.service.EmployeeService;

import java.time.LocalDate;

/**
 * Реализация интерфейса для взаимодействия с сотрудниками
 */
public class EmployeeServiceImpl extends ServiceImpl<Employee> implements EmployeeService {

    private BankOfficeService bankOfficeService;

    public EmployeeServiceImpl(BankOfficeService bankOfficeService) {
        this.bankOfficeService = bankOfficeService;
    }

    @Override
    public void create(Long id, String name, LocalDate birthDate, String jobTitle, String bankName, Boolean isWorkingInOffice, BankOffice bankOffice, Boolean isPossibleGetLoan, Double salary) {
        this.model = new Employee(id, name, birthDate, jobTitle, bankName, isWorkingInOffice, bankOffice, isPossibleGetLoan, salary);
        this.bankOfficeService.addEmployee();
    }
}
