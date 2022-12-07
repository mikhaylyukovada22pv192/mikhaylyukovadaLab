package tech.reliab.course.mikhaylyukovada.bank.entity.common;

/**
 * Общая модель данных
 */
public class BankObject {

    protected Long id;

    /**
     * Путой конструктор модели
     */
    public BankObject() {}

    /**
     * Конструктор для создания модели
     *
     * @param id id объекта
     */
    public BankObject(Long id) {
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