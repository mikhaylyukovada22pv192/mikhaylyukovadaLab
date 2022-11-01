package tech.reliab.course.mikhaylyukovada.bank.service.impl;

import tech.reliab.course.mikhaylyukovada.bank.entity.PaymentAccount;
import tech.reliab.course.mikhaylyukovada.bank.entity.User;
import tech.reliab.course.mikhaylyukovada.bank.service.PaymentAccountService;

/**
 * Реализация интерфейса для взаимодействия с платежными счетами
 */
public class PaymentAccountServiceImpl extends ServiceImpl<PaymentAccount> implements PaymentAccountService {

    @Override
    public void create(Long id, User user, String bankName) {
        this.model = new PaymentAccount(id, user, bankName);
    }
}
