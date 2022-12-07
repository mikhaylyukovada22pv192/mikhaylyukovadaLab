package tech.reliab.course.mikhaylyukovada.bank.repository;

import tech.reliab.course.mikhaylyukovada.bank.entity.CreditAccount;
import tech.reliab.course.mikhaylyukovada.bank.repository.common.BasicModelRepositoryImpl;

/**
 * Репозиторий кредитных счетов
 */
public class CreditAccountRepository extends BasicModelRepositoryImpl<CreditAccount> {
    private static CreditAccountRepository INSTANCE;

    public static CreditAccountRepository getInstance() {
        if (INSTANCE == null) { INSTANCE = new CreditAccountRepository(); }

        return INSTANCE;
    }
}
