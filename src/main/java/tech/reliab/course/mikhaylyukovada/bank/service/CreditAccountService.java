package tech.reliab.course.mikhaylyukovada.bank.service;

import tech.reliab.course.mikhaylyukovada.bank.entity.*;
import tech.reliab.course.mikhaylyukovada.bank.service.common.BankObjectService;

/**
 * Интерфейс для взаимодействия с кредитными счетами
 */
public interface CreditAccountService extends BankObjectService<CreditAccount> {

    /**
     * Создает и возвращает модель кредитного счета
     *
     * @param user пользователь счета
     * @param bank банк
     * @param employee сотрудник
     * @param paymentAccount платежный счет
     * @param sum сумма кредита
     * @param monthNumber кол-во месяцев
     */
    CreditAccount createCreditAccount(Bank bank, User user, PaymentAccount paymentAccount, Employee employee, Double sum, int monthNumber);
}
