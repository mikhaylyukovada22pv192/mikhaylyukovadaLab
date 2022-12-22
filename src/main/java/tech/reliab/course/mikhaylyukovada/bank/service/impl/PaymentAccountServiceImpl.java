package tech.reliab.course.mikhaylyukovada.bank.service.impl;

import tech.reliab.course.mikhaylyukovada.bank.entity.Bank;
import tech.reliab.course.mikhaylyukovada.bank.entity.PaymentAccount;
import tech.reliab.course.mikhaylyukovada.bank.entity.User;
import tech.reliab.course.mikhaylyukovada.bank.exceptions.IdNotFoundException;
import tech.reliab.course.mikhaylyukovada.bank.exceptions.WrongNameException;
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

    public PaymentAccount createPaymentAccount(Bank bank, User user) {
        return new PaymentAccount(user, bank.getName());
    }

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
        if (id == null) {
            throw new IdNotFoundException();
        }

        return paymentAccountRepository.deleteById(id);
    }

    @Override
    public PaymentAccount getObjectById(Long id) {
        if (id == null) {
            throw new IdNotFoundException();
        }

        return paymentAccountRepository.findById(id);
    }

    @Override
    public List<PaymentAccount> getAllObjects() {
        return paymentAccountRepository.findAll();
    }

    @Override
    public List<PaymentAccount> getAllPaymentAccount(String bankName, Long userId) {
        return paymentAccountRepository.findAll()
                .stream()
                .filter(account -> account.getBankName().equals(bankName) && account.getUser().getId().compareTo(userId) == 0)
                .toList();
    }

    @Override
    public PaymentAccount getPaymentAccount(Bank bank, User user) {
        if(!user.getBanks().contains(bank)){
            return this.addObject(this.createPaymentAccount(bank, user));

        }else {
            return this.getAllPaymentAccount(bank.getName(), user.getId())
                    .stream()
                    .findFirst().get();
        }
    }

    @Override
    public List<PaymentAccount> getAllPaymentAccounts(Bank bank) {
        return paymentAccountRepository.findAll()
                .stream()
                .filter(account -> account.getBankName().equals(bank.getName()))
                .toList();
    }
}
