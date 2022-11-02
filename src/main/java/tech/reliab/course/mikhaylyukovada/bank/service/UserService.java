package tech.reliab.course.mikhaylyukovada.bank.service;

import tech.reliab.course.mikhaylyukovada.bank.entity.Bank;
import tech.reliab.course.mikhaylyukovada.bank.entity.User;

import java.time.LocalDate;

/**
 * Интерфейс для взаимодействия с пользователями
 */
public interface UserService extends Service<User> {

    /**
     * Создает модель пользователя
     *
     * @param id id пользователя
     * @param name имя пользователя
     * @param birthDate дата рождения
     * @param workPlace место работы
     * @param bank банк, которым пользуется
     */
    void create(Long id, String name, LocalDate birthDate, String workPlace, Bank bank);

}
