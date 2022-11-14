package tech.reliab.course.mikhaylyukovada.bank.repository;

import tech.reliab.course.mikhaylyukovada.bank.entity.Employee;
import tech.reliab.course.mikhaylyukovada.bank.repository.common.BankObjectRepositoryImpl;

/**
 * Репозиторий сотрудников
 */
public class EmployeeRepository extends BankObjectRepositoryImpl<Employee> {
    private static EmployeeRepository INSTANCE;

    public static EmployeeRepository getInstance() {
        if (INSTANCE == null) { INSTANCE = new EmployeeRepository(); }

        return INSTANCE;
    }
}
