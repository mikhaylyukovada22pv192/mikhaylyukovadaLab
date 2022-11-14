package tech.reliab.course.mikhaylyukovada.bank.service;

import tech.reliab.course.mikhaylyukovada.bank.entity.Bank;
import tech.reliab.course.mikhaylyukovada.bank.service.common.BankObjectService;
import java.io.OutputStream;

/**
 * Интерфейс для взаимодействия с банками
 */
public interface BankService extends BankObjectService<Bank>  {

    /**
     * Вывод всей информации о банке
     *
     * @param bankId id банка
     */
    void outputBankInfo(Long bankId);
}
