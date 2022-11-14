package tech.reliab.course.mikhaylyukovada.bank.repository;

import tech.reliab.course.mikhaylyukovada.bank.entity.Bank;
import tech.reliab.course.mikhaylyukovada.bank.repository.common.BankObjectRepositoryImpl;

/**
 * Репозиторий банков
 */
public class BankRepository extends BankObjectRepositoryImpl<Bank> {
    private static BankRepository INSTANCE;

    public static BankRepository getInstance() {
        if (INSTANCE == null) { INSTANCE = new BankRepository(); }

        return INSTANCE;
    }
}
