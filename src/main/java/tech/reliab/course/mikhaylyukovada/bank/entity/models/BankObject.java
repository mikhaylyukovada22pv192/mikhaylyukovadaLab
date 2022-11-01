package tech.reliab.course.mikhaylyukovada.bank.entity.models;

/**
 * Общая модель данных
 */
public class BankObject {

    protected Long id;

    /**
     * Конструктор для создания модели
     *
     * @param id id объекта
     */
    public BankObject(Long id) {
        this.id = id;
    }

    /**
     * @return id объекта
     */
    public Long getId() {
        return id;
    }
}
