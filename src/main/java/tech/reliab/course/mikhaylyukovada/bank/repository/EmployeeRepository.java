package tech.reliab.course.mikhaylyukovada.bank.repository;

import tech.reliab.course.mikhaylyukovada.bank.entity.Employee;
import tech.reliab.course.mikhaylyukovada.bank.repository.common.CrudObjectRepositoryImpl;

/**
 * Репозиторий сотрудников
 */
public class EmployeeRepository extends CrudObjectRepositoryImpl<Employee> {
    private static EmployeeRepository INSTANCE;

    public static EmployeeRepository getInstance() {
        if (INSTANCE == null) { INSTANCE = new EmployeeRepository(); }

        return INSTANCE;
    }
}
