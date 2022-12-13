package tech.reliab.course.mikhaylyukovada.bank.service.common;

import tech.reliab.course.mikhaylyukovada.bank.entity.common.BasicModel;
import java.util.List;

/**
 * Интерфейс базовых сервисов банка
 *
 * @param <T> объекты банка
 */
public interface BasicModelService<T extends BasicModel> {

    /**
     * Добавляет объект
     * @return добавленный объект
     *
     * @param object объект
     */
    T addObject(T object);

    /**
     * Обновляет объект
     * @return обновленный объект
     *
     * @param object объект
     */
    T updateObject(T object);

    /**
     * Удаляет объект по id
     * @return true при успешном удалении
     *
     * @param id id объекта
     */
    boolean deleteObjectById(Long id);

    /**
     * @return объект по заданному id
     *
     * @param id id объекта
     */
    T getObjectById(Long id);

    /**
     * @return список объектов
     */
    List<T> getAllObjects();
}
