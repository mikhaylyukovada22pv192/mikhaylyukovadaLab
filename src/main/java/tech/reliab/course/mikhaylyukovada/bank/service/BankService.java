package tech.reliab.course.mikhaylyukovada.bank.service;

import tech.reliab.course.mikhaylyukovada.bank.entity.Bank;
import tech.reliab.course.mikhaylyukovada.bank.service.common.BasicModelService;

/**
 * Интерфейс для взаимодействия с банками
 */
public interface BankService extends BasicModelService<Bank> {

    /**
     * Вывод всей информации о банке
     *
     * @param bankId id банка
     */
    void outputBankInfo(Long bankId);
}
