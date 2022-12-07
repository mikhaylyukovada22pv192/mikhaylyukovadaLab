package tech.reliab.course.mikhaylyukovada.bank.repository;

import tech.reliab.course.mikhaylyukovada.bank.entity.PaymentAccount;
import tech.reliab.course.mikhaylyukovada.bank.repository.common.CrudObjectRepositoryImpl;

/**
 * Репозиторий платежных счетов
 */
public class PaymentAccountRepository extends CrudObjectRepositoryImpl<PaymentAccount> {
    private static PaymentAccountRepository INSTANCE;

    public static PaymentAccountRepository getInstance() {
        if (INSTANCE == null) { INSTANCE = new PaymentAccountRepository(); }

        return INSTANCE;
    }
}
