package tech.reliab.course.mikhaylyukovada.bank.repository;

import tech.reliab.course.mikhaylyukovada.bank.entity.BankAtm;
import tech.reliab.course.mikhaylyukovada.bank.repository.common.CrudObjectRepositoryImpl;

/**
 * Репозиторий АТМ
 */
public class AtmRepositoryBank extends CrudObjectRepositoryImpl<BankAtm> {
    private static AtmRepositoryBank INSTANCE;

    public static AtmRepositoryBank getInstance() {
        if (INSTANCE == null) { INSTANCE = new AtmRepositoryBank(); }

        return INSTANCE;
    }
}
