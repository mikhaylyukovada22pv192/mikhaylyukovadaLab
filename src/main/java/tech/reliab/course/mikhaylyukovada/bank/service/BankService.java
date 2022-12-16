package tech.reliab.course.mikhaylyukovada.bank.service;

import tech.reliab.course.mikhaylyukovada.bank.entity.Bank;
import tech.reliab.course.mikhaylyukovada.bank.service.common.BasicModelService;
import tech.reliab.course.mikhaylyukovada.bank.exceptions.FailedLoanException;

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

    /**
     * Выводит счета банка в txt файл
     *
     * @param bankId id банка
     * @param filename имя файла
     */
    void exportAccounts(Long bankId, String filename);

    /**
     * Выводит счета пользователя банка в txt файл
     *
     * @param bankId id банка
     * @param userId id пользователя
     * @param filename имя файла
     */
    void exportUserAccounts(Long bankId, Long userId, String filename);

    /**
     * Считывает счета из txt файла в банк
     *
     * @param bankId id банка
     * @param filename имя файла
     */
    void importAccounts(Long bankId, String filename);

    /**
     * Переносит счета из одно банка в другой
     *
     * @param srcBankId id банка, из которого будут перенесены счета
     * @param dstBankId id банка, в который будут перенесены счета
     */
    void transferAccounts(Long srcBankId, Long dstBankId);
}
