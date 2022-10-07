package tech.reliab.course.mikhaylyukovada.bank.service;

import tech.reliab.course.mikhaylyukovada.bank.entity.PaymentAccount;
import tech.reliab.course.mikhaylyukovada.bank.entity.User;

/**
 * Интерфейс для взаимодействия с платежными счетами
 */
public interface PaymentAccountService {

    /**
     * Созадет модель платежного счета
     *
     * @param id id счета
     * @param user пользователь счета
     * @param bankName название банка
     */
    void create(Long id, User user, String bankName);

    /**
     * @return платежный счет
     */
    PaymentAccount read();

    /**
     * Обновляет платежный счет
     *
     * @param paymentAccount платежный счет
     */
    void update(PaymentAccount paymentAccount);

    /**
     * Удаляет платежный счет
     */
    void delete();
}
