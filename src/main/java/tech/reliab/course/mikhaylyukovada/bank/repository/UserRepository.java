package tech.reliab.course.mikhaylyukovada.bank.repository;

import tech.reliab.course.mikhaylyukovada.bank.entity.User;
import tech.reliab.course.mikhaylyukovada.bank.repository.common.BasicModelRepositoryImpl;

/**
 * Репозиторий пользователей
 */
public class UserRepository extends BasicModelRepositoryImpl<User> {
    private static UserRepository INSTANCE;

    public static UserRepository getInstance() {
        if (INSTANCE == null) { INSTANCE = new UserRepository(); }

        return INSTANCE;
    }
}
