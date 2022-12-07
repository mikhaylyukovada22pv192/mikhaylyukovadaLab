package tech.reliab.course.mikhaylyukovada.bank.repository;

import tech.reliab.course.mikhaylyukovada.bank.entity.User;
import tech.reliab.course.mikhaylyukovada.bank.repository.common.CrudObjectRepositoryImpl;

/**
 * Репозиторий пользователей
 */
public class UserRepository extends CrudObjectRepositoryImpl<User> {
    private static UserRepository INSTANCE;

    public static UserRepository getInstance() {
        if (INSTANCE == null) { INSTANCE = new UserRepository(); }

        return INSTANCE;
    }
}
