package tech.reliab.course.mikhaylyukovada.bank.entity.common;

/**
 * Базовая модель данных
 */
public class BasicModel {

    protected Long id;

    /**
     * Путой конструктор модели
     */
    public BasicModel() {}

    /**
     * Конструктор для создания модели
     *
     * @param id id объекта
     */
    public BasicModel(Long id) {
        this.id = id;
    }

    /**
     * Задает id объекта
     *
     * @param id id объекта
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return id объекта
     */
    public Long getId() {
        return id;
    }
}
