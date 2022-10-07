package tech.reliab.course.mikhaylyukovada.bank.service.impl;

import tech.reliab.course.mikhaylyukovada.bank.entity.PaymentAccount;
import tech.reliab.course.mikhaylyukovada.bank.entity.User;
import tech.reliab.course.mikhaylyukovada.bank.service.PaymentAccountService;

/**
 * Реализация интерфейса для взаимодействия с платежными счетами
 */
public class PaymentAccountServiceImpl implements PaymentAccountService {

    private PaymentAccount paymentAccount = null;

    @Override
    public void create(Long id, User user, String bankName) {
        this.paymentAccount = new PaymentAccount(id, user, bankName);
    }

    @Override
    public PaymentAccount read() {
        return paymentAccount;
    }

    @Override
    public void update(PaymentAccount paymentAccount) {
        this.paymentAccount = paymentAccount;
    }

    @Override
    public void delete() {
        this.paymentAccount = null;
    }
}
