package tech.reliab.course.mikhaylyukovada.bank.service;

import tech.reliab.course.mikhaylyukovada.bank.entity.Bank;

/**
 * Интерфейс для взаимодействия с банками
 */
public interface BankService {

    /**
     * Созадет модель банка
     *
     * @param id id банка
     * @param name название
     */
    void create(Long id, String name);

    /**
     * @return модель банка
     */
    Bank read();

    /**
     * Обновляет модель банка
     *
     * @param bank банк
     */
    void update(Bank bank);

    /**
     * Удаляет модель банка
     */
    void delete();

}
