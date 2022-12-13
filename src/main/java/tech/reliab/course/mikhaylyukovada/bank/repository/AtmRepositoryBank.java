package tech.reliab.course.mikhaylyukovada.bank.repository;

import tech.reliab.course.mikhaylyukovada.bank.entity.BankAtm;
import tech.reliab.course.mikhaylyukovada.bank.repository.common.BasicModelRepositoryImpl;

/**
 * Репозиторий АТМ
 */
public class AtmRepositoryBank extends BasicModelRepositoryImpl<BankAtm> {
    private static AtmRepositoryBank INSTANCE;

    public static AtmRepositoryBank getInstance() {
        if (INSTANCE == null) { INSTANCE = new AtmRepositoryBank(); }

        return INSTANCE;
    }
}
