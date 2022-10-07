package tech.reliab.course.mikhaylyukovada.bank.service;

import tech.reliab.course.mikhaylyukovada.bank.entity.BankOffice;
import tech.reliab.course.mikhaylyukovada.bank.entity.Employee;

import java.time.LocalDate;

/**
 * Интерфейс для взаимодействия с сотрудниками
 */
public interface EmployeeService {

    /**
     * Создает модель сотрудника
     *
     * @param id id сотрудника
     * @param name имя сотрудника
     * @param birthDate дата рождения
     * @param jobTitle должность
     * @param bankName название банка
     * @param isWorkingInOffice работает ли в офисе
     * @param bankOffice офис, в котором работает
     * @param isPossibleGetLoan может ли выдать кредит
     * @param salary зарплата
     */
    void create(Long id, String name, LocalDate birthDate, String jobTitle, String bankName, Boolean isWorkingInOffice, BankOffice bankOffice, Boolean isPossibleGetLoan, Double salary);

    /**
     * @return модель сотрудника
     */
    Employee read();

    /**
     * Обновляет модель сотрудника
     *
     * @param employee сотрудник
     */
    void update(Employee employee);

    /**
     * Удаляет сотрудника
     */
    void delete();
}
