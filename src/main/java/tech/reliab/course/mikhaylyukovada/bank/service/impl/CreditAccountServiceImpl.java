package tech.reliab.course.mikhaylyukovada.bank.service.impl;

import tech.reliab.course.mikhaylyukovada.bank.entity.CreditAccount;
import tech.reliab.course.mikhaylyukovada.bank.repository.CreditAccountRepository;
import tech.reliab.course.mikhaylyukovada.bank.service.CreditAccountService;
import java.util.List;

/**
 * Реализация интерфейса для взаимодействия с кредитными счетами
 */
public class CreditAccountServiceImpl implements CreditAccountService {
    private static CreditAccountServiceImpl INSTANCE;

    public static CreditAccountServiceImpl getInstance() {
        if (INSTANCE == null) { INSTANCE = new CreditAccountServiceImpl(); }

        return INSTANCE;
    }

    private final CreditAccountRepository creditAccountRepository = CreditAccountRepository.getInstance();

    @Override
    public CreditAccount addObject(CreditAccount creditAccount) {
        creditAccount.setEndDate(creditAccount.getStartDate().plusMonths(creditAccount.getMonthsNumber()));

        var monthlyPayment = creditAccount.getCreditAmount() / creditAccount.getMonthsNumber().doubleValue() * creditAccount.getInterestRate();
        creditAccount.setMonthlyPayment(monthlyPayment);

        return creditAccountRepository.add(creditAccount);
    }

    @Override
    public CreditAccount updateObject(CreditAccount creditAccount) {
        return creditAccountRepository.update(creditAccount);
    }

    @Override
    public boolean deleteObjectById(Long id) {
        return creditAccountRepository.deleteById(id);
    }

    @Override
    public CreditAccount getObjectById(Long id) {
        return creditAccountRepository.findById(id);
    }

    @Override
    public List<CreditAccount> getAllObjects() {
        return creditAccountRepository.findAll();
    }
}
