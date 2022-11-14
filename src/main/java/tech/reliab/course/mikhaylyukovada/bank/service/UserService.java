package tech.reliab.course.mikhaylyukovada.bank.service;

import tech.reliab.course.mikhaylyukovada.bank.entity.User;
import tech.reliab.course.mikhaylyukovada.bank.service.common.BankObjectService;

/**
 * Интерфейс для взаимодействия с пользователями
 */
public interface UserService extends BankObjectService<User> {

    /**
     * Вывод всей информации о счетах пользователя
     *
     * @param userId id пользователя
     */
    void outputUserAccounts(Long userId);
}
