package tech.reliab.course.mikhaylyukovada.bank.repository.common;

import tech.reliab.course.mikhaylyukovada.bank.entity.common.BankObject;

import java.util.List;

/**
 * Интерфейс с методами CRUD для взаимодейтсвия с объектами
 *
 * @param <T> объекты банка
 */
public interface CrudObjectRepository<T extends BankObject> {

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
