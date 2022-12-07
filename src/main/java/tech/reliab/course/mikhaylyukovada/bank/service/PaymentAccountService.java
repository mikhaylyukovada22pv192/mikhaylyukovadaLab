package tech.reliab.course.mikhaylyukovada.bank.service;

import tech.reliab.course.mikhaylyukovada.bank.entity.Bank;
import tech.reliab.course.mikhaylyukovada.bank.entity.PaymentAccount;
import tech.reliab.course.mikhaylyukovada.bank.entity.User;
import tech.reliab.course.mikhaylyukovada.bank.service.common.BankObjectService;
import java.util.List;

/**
 * Интерфейс для взаимодействия с платежными счетами
 */
public interface PaymentAccountService extends BankObjectService<PaymentAccount> {

    /**
     * Возвращает платёжные счета клиента в выбранном банке
     *
     * @param bankName название банка
     * @param userId id клиента
     */
    List<PaymentAccount> getAllPaymentAccount(String bankName, Long userId);

    /**
     * Возвращает счет пользователя в выбранном банке. Созадет счет, если его не было
     *
     * @param bank банк
     * @param user пользователь
     */
    PaymentAccount getPaymentAccount(Bank bank, User user);

    /**
     * Возвращает все счета, хранящиеся в банке
     *
     * @param bank банк
     */
    List<PaymentAccount> getAllPaymentAccounts(Bank bank);
}
