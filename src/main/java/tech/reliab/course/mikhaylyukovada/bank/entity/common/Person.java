package tech.reliab.course.mikhaylyukovada.bank.entity.common;

import java.time.LocalDate;

/**
 * Модель человека
 */
public class Person extends BasicModel {

    protected String name;
    protected LocalDate birthDate;

    public Person() {}

    /**
     * Конструктор для создания модели человека
     *
     * @param name имя человека
     * @param birthDate дата рождения
     */
    public Person(String name, LocalDate birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }

    /**
     * Конструктор для создания модели человека
     *
     * @param id id человека
     * @param name имя человека
     * @param birthDate дата рождения
     */
    public Person(Long id, String name, LocalDate birthDate) {
        super(id);
        this.name = name;
        this.birthDate = birthDate;
    }

    /**
     * @return имя человека
     */
    public String getName() {
        return name;
    }

    /**
     * @return дату рождения
     */
    public LocalDate getBirthDate() {
        return birthDate;
    }

    /**
     * Задает имя человека
     *
     * @param name человек
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Задает дату рождения человека
     *
     * @param birthDate дата рождения
     */
    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
}
