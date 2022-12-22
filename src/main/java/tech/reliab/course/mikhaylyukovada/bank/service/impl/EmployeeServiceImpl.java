package tech.reliab.course.mikhaylyukovada.bank.service.impl;

import tech.reliab.course.mikhaylyukovada.bank.entity.BankOffice;
import tech.reliab.course.mikhaylyukovada.bank.entity.Employee;
import tech.reliab.course.mikhaylyukovada.bank.exceptions.IdNotFoundException;
import tech.reliab.course.mikhaylyukovada.bank.exceptions.WrongNameException;
import tech.reliab.course.mikhaylyukovada.bank.repository.EmployeeRepository;
import tech.reliab.course.mikhaylyukovada.bank.service.BankOfficeService;
import tech.reliab.course.mikhaylyukovada.bank.service.EmployeeService;
import java.util.List;

/**
 * Реализация интерфейса для взаимодействия с сотрудниками
 */
public class EmployeeServiceImpl implements EmployeeService {
    private static EmployeeServiceImpl INSTANCE;

    public static EmployeeServiceImpl getInstance() {
        if (INSTANCE == null) { INSTANCE = new EmployeeServiceImpl(); }

        return INSTANCE;
    }

    private final EmployeeRepository employeeRepository = EmployeeRepository.getInstance();
    private final BankOfficeService bankOfficeService = BankOfficeServiceImpl.getInstance();

    @Override
    public Employee addObject(Employee employee) {
        if (employee.getName().isBlank()) {
            throw new WrongNameException();
        }

        Employee newEmployee = employeeRepository.add(employee);
        BankOffice office = newEmployee.getBankOffice();

        if (office != null) {
            bankOfficeService.addEmployee(office.getId());
        } else {
            throw new IdNotFoundException();
        }

        return newEmployee;

    }

    @Override
    public Employee updateObject(Employee employee) {
        return employeeRepository.update(employee);
    }

    @Override
    public boolean deleteObjectById(Long id) {
        Long officeId = employeeRepository.findById(id).getBankOffice().getId();

        if (officeId == null) {
            throw new IdNotFoundException();
        }

        if (bankOfficeService.deleteEmployee(officeId)) {
            return employeeRepository.deleteById(id);
        }
        return false;
    }

    @Override
    public Employee getObjectById(Long id) {
        if (id == null) {
            throw new IdNotFoundException();
        }

        return employeeRepository.findById(id);
    }

    @Override
    public List<Employee> getAllObjects() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeWithLoan(Long officeId) {
        var firstEmployee = employeeRepository.findAll()
                .stream()
                .filter(employee -> employee.getBankOffice().getId().compareTo(officeId) == 0)
                .filter(Employee::getPossibleGetLoan)
                .findFirst();

        if(firstEmployee.isEmpty()){
            return null;
        }

        return firstEmployee.get();

    }
}
