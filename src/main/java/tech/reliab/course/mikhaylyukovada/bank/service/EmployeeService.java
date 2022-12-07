package tech.reliab.course.mikhaylyukovada.bank.service;

import tech.reliab.course.mikhaylyukovada.bank.entity.Employee;
import tech.reliab.course.mikhaylyukovada.bank.service.common.BankObjectService;

/**
 * Интерфейс для взаимодействия с сотрудниками
 */
public interface EmployeeService extends BankObjectService<Employee> {

    /**
     * Возвращает работника, который может выдать кредит
     *
     * @param officeId id офиса
     */
    Employee getEmployeeWithLoan(Long officeId);
}
