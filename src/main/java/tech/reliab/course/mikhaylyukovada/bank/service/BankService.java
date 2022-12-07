package tech.reliab.course.mikhaylyukovada.bank.service;

import tech.reliab.course.mikhaylyukovada.bank.entity.Bank;
import tech.reliab.course.mikhaylyukovada.bank.service.common.BasicModelService;
import tech.reliab.course.mikhaylyukovada.bank.exceptions.FailedLoanException;
import tech.reliab.course.mikhaylyukovada.bank.service.common.BankObjectService;

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

    /**
     * Выдает кредит и возвраащет его id
     *
     * @param userId id пользователя
     * @param creditSum сумма кредита
     */
    Long getLoan(Long userId, Double creditSum) throws FailedLoanException;
}
