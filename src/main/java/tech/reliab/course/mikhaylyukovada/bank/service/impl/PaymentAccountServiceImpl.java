package tech.reliab.course.mikhaylyukovada.bank.service.impl;

import tech.reliab.course.mikhaylyukovada.bank.entity.PaymentAccount;
import tech.reliab.course.mikhaylyukovada.bank.repository.PaymentAccountRepository;
import tech.reliab.course.mikhaylyukovada.bank.service.PaymentAccountService;
import java.util.List;

/**
 * Реализация интерфейса для взаимодействия с платежными счетами
 */
public class PaymentAccountServiceImpl implements PaymentAccountService {
    private static PaymentAccountServiceImpl INSTANCE;

    public static PaymentAccountServiceImpl getInstance() {
        if (INSTANCE == null) { INSTANCE = new PaymentAccountServiceImpl(); }

        return INSTANCE;
    }

    private final PaymentAccountRepository paymentAccountRepository = PaymentAccountRepository.getInstance();

    @Override
    public PaymentAccount addObject(PaymentAccount paymentAccount) {
        return paymentAccountRepository.add(paymentAccount);
    }

    @Override
    public PaymentAccount updateObject(PaymentAccount paymentAccount) {
        return paymentAccountRepository.update(paymentAccount);
    }

    @Override
    public boolean deleteObjectById(Long id) {
        return false;
    }

    @Override
    public PaymentAccount getObjectById(Long id) {
        return paymentAccountRepository.findById(id);
    }

    @Override
    public List<PaymentAccount> getAllObjects() {
        return paymentAccountRepository.findAll();
    }
}
