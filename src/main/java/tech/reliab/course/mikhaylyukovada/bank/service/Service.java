package tech.reliab.course.mikhaylyukovada.bank.service;

import tech.reliab.course.mikhaylyukovada.bank.entity.models.BankObject;

/**
 * Интерфейс с общими методами банковских сервисов
 *
 * @param <T> объекты банка
 */
public interface Service<T extends BankObject> {

    /**
     * @return модель
     */
    T read();

    /**
     * Обновляет модель
     *
     * @param model модель
     */
    void update(T model);

    /**
     * Удаляет модель
     */
    void delete();
}
