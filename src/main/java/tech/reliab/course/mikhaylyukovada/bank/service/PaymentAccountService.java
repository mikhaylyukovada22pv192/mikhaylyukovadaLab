package tech.reliab.course.mikhaylyukovada.bank.service;

import tech.reliab.course.mikhaylyukovada.bank.entity.Bank;
import tech.reliab.course.mikhaylyukovada.bank.entity.PaymentAccount;
import tech.reliab.course.mikhaylyukovada.bank.service.common.BasicModelService;
import tech.reliab.course.mikhaylyukovada.bank.entity.User;
import java.util.List;

/**
 * Интерфейс для взаимодействия с платежными счетами
 */
public interface PaymentAccountService extends BasicModelService<PaymentAccount> {

    /**
     * Возвращает платёжные счета клиента в выбранном банке
     *
     * @param bankName название банка
     * @param userId id клиента
     */
    List<PaymentAccount> getAllPaymentAccount(String bankName, Long userId);

    /**
     * Возвращает счет пользователя в выбранном банке или null, если его не было
     *
     * @param bank банк
     * @param user пользователь
     */
    PaymentAccount getPaymentAccount(Bank bank, User user);

    /**
     * Созадет счет пользователя в выбранном банке
     *
     * @param bank банк
     * @param user пользователь
     */
    PaymentAccount getNewPaymentAccount(Bank bank, User user);
}
