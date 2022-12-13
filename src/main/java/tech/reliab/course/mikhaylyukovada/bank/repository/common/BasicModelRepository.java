package tech.reliab.course.mikhaylyukovada.bank.repository.common;

import tech.reliab.course.mikhaylyukovada.bank.entity.common.BasicModel;

import java.util.List;

/**
 * Интерфейс с базовыми методами взаимодействия с объектами
 *
 * @param <T> объекты банка
 */
public interface BasicModelRepository<T extends BasicModel> {

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
