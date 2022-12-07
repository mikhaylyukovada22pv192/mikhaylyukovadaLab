package tech.reliab.course.mikhaylyukovada.bank.repository;

import tech.reliab.course.mikhaylyukovada.bank.entity.BankOffice;
import tech.reliab.course.mikhaylyukovada.bank.repository.common.CrudObjectRepositoryImpl;

/**
 * Репозиторий офисов
 */
public class BankOfficeRepository extends CrudObjectRepositoryImpl<BankOffice> {
    private static BankOfficeRepository INSTANCE;

    public static BankOfficeRepository getInstance() {
        if (INSTANCE == null) { INSTANCE = new BankOfficeRepository(); }

        return INSTANCE;
    }
}
