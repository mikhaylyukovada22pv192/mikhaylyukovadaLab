package tech.reliab.course.mikhaylyukovada.bank.service;

import tech.reliab.course.mikhaylyukovada.bank.entity.Bank;

/**
 * Интерфейс для взаимодействия с банками
 */
public interface BankService extends Service<Bank> {

    /**
     * Созадет модель банка
     *
     * @param id id банка
     * @param name название
     */
    void create(Long id, String name);

    /**
     * Добавляет офис
     */
    void addOffice();

    /**
     * Добавляет АТМ
     */
    void addAtm();

    /**
     * Добавляет работника
     */
    void addEmployee();

    /**
     * Добавляет клиента
     */
    void addClient();

}
