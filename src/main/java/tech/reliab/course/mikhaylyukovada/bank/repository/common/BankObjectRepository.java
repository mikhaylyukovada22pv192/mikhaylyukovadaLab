package tech.reliab.course.mikhaylyukovada.bank.repository.common;

import tech.reliab.course.mikhaylyukovada.bank.entity.models.BankObject;

import java.util.List;

/**
 * Интерфейс с методами для взаимодейтсвия с банковскими объектами
 *
 * @param <T> объекты банка
 */
public interface BankObjectRepository<T extends BankObject> {

    /**
     * Добавляет объект
     * @return добавленный объект
     *
     * @param object объект
     */
    T add(T object);

    /**
     * Обновляет объект
     * @return обновленный объект
     *
     * @param object объект
     */
    T update(T object);

    /**
     * Удаляет объект по id
     * @return true при успешном удалении
     *
     * @param id id объекта
     */
    boolean deleteById(Long id);

    /**
     * @return объект по заданному id
     *
     * @param id id объекта
     */
    T findById(Long id);

    /**
     * @return список объектов
     */
    List<T> findAll();
}
