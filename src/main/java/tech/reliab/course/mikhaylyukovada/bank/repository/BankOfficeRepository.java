package tech.reliab.course.mikhaylyukovada.bank.repository;

import tech.reliab.course.mikhaylyukovada.bank.entity.BankOffice;
import tech.reliab.course.mikhaylyukovada.bank.repository.common.BasicModelRepositoryImpl;

/**
 * Репозиторий офисов
 */
public class BankOfficeRepository extends BasicModelRepositoryImpl<BankOffice> {
    private static BankOfficeRepository INSTANCE;

    public static BankOfficeRepository getInstance() {
        if (INSTANCE == null) { INSTANCE = new BankOfficeRepository(); }

        return INSTANCE;
    }
}
