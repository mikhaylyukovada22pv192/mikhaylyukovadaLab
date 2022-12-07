package tech.reliab.course.mikhaylyukovada.bank.repository;

import tech.reliab.course.mikhaylyukovada.bank.entity.Bank;
import tech.reliab.course.mikhaylyukovada.bank.repository.common.CrudObjectRepositoryImpl;

/**
 * Репозиторий банков
 */
public class BankRepository extends CrudObjectRepositoryImpl<Bank> {
    private static BankRepository INSTANCE;

    public static BankRepository getInstance() {
        if (INSTANCE == null) { INSTANCE = new BankRepository(); }

        return INSTANCE;
    }
}
