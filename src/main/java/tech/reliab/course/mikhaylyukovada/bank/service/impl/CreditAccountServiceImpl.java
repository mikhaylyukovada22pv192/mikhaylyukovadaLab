package tech.reliab.course.mikhaylyukovada.bank.service.impl;

import tech.reliab.course.mikhaylyukovada.bank.entity.*;
import tech.reliab.course.mikhaylyukovada.bank.exceptions.IdNotFoundException;
import tech.reliab.course.mikhaylyukovada.bank.exceptions.WrongNameException;
import tech.reliab.course.mikhaylyukovada.bank.exceptions.WrongPaymentException;
import tech.reliab.course.mikhaylyukovada.bank.repository.CreditAccountRepository;
import tech.reliab.course.mikhaylyukovada.bank.service.CreditAccountService;

import java.time.LocalDate;
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

    public CreditAccount createCreditAccount(Bank bank, User user, PaymentAccount paymentAccount, Employee employee, Double sum, int monthNumber) {
        return new CreditAccount(user, bank.getName(), LocalDate.now(), monthNumber, sum,
                bank.getInterestRate(), employee, paymentAccount);
    }

    private final CreditAccountRepository creditAccountRepository = CreditAccountRepository.getInstance();

    @Override
    public CreditAccount addObject(CreditAccount creditAccount) {
        creditAccount.setEndDate(creditAccount.getStartDate().plusMonths(creditAccount.getMonthsNumber()));

        var monthlyPayment = creditAccount.getCreditAmount() / creditAccount.getMonthsNumber().doubleValue() * creditAccount.getInterestRate();

        if (monthlyPayment <= 0) {
            throw new WrongPaymentException();
        }

        creditAccount.setMonthlyPayment(monthlyPayment);

        return creditAccountRepository.add(creditAccount);
    }

    @Override
    public CreditAccount updateObject(CreditAccount creditAccount) {
        return creditAccountRepository.update(creditAccount);
    }

    @Override
    public boolean deleteObjectById(Long id) {
        if (id == null) {
            throw new IdNotFoundException();
        }

        return creditAccountRepository.deleteById(id);
    }

    @Override
    public CreditAccount getObjectById(Long id) {
        if (id == null) {
            throw new IdNotFoundException();
        }

        return creditAccountRepository.findById(id);
    }

    @Override
    public List<CreditAccount> getAllObjects() {
        return creditAccountRepository.findAll();
    }

    @Override
    public List<CreditAccount> getAllCreditAccounts(Bank bank) {
        return creditAccountRepository.findAll()
                .stream()
                .filter(account -> account.getBankName().equals(bank.getName()))
                .toList();
    }
}
