package tech.reliab.course.mikhaylyukovada.bank.repository;

import tech.reliab.course.mikhaylyukovada.bank.entity.User;
import tech.reliab.course.mikhaylyukovada.bank.repository.common.BankObjectRepositoryImpl;

/**
 * Репозиторий пользователей
 */
public class UserRepository extends BankObjectRepositoryImpl<User> {
    private static UserRepository INSTANCE;

    public static UserRepository getInstance() {
        if (INSTANCE == null) { INSTANCE = new UserRepository(); }

        return INSTANCE;
    }
}
