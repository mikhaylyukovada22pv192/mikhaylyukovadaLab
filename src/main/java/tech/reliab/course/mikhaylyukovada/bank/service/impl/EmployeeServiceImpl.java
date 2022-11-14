package tech.reliab.course.mikhaylyukovada.bank.service.impl;

import tech.reliab.course.mikhaylyukovada.bank.entity.BankOffice;
import tech.reliab.course.mikhaylyukovada.bank.entity.Employee;
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
        Employee newEmployee = employeeRepository.add(employee);
        BankOffice office = newEmployee.getBankOffice();

        if (office != null) {
            bankOfficeService.addEmployee(office.getId());
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

        if (bankOfficeService.deleteEmployee(officeId)) {
            return employeeRepository.deleteById(id);
        }
        return false;
    }

    @Override
    public Employee getObjectById(Long id) {
        return employeeRepository.findById(id);
    }

    @Override
    public List<Employee> getAllObjects() {
        return employeeRepository.findAll();
    }

}
