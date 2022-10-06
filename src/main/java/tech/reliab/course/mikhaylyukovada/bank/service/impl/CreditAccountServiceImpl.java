package tech.reliab.course.mikhaylyukovada.bank.service.impl;

import tech.reliab.course.mikhaylyukovada.bank.entity.CreditAccount;
import tech.reliab.course.mikhaylyukovada.bank.entity.Employee;
import tech.reliab.course.mikhaylyukovada.bank.entity.User;
import tech.reliab.course.mikhaylyukovada.bank.service.CreditAccountService;

import java.time.LocalDate;

public class CreditAccountServiceImpl implements CreditAccountService {

    private CreditAccount creditAccount = null;

    @Override
    public void create(Long id, User user, String bankName, LocalDate startDate, LocalDate endDate, Integer monthsNumber, Double creditAmount, Double monthlyPayment, Double interestRate, Employee employee, String paymentAccount) {
        this.creditAccount = new CreditAccount(id, user, bankName, startDate, endDate, monthsNumber, creditAmount, monthlyPayment, interestRate, employee, paymentAccount);
    }

    @Override
    public CreditAccount read() {
        return creditAccount;
    }

    @Override
    public void update(CreditAccount creditAccount) {
        this.creditAccount = creditAccount;
    }

    @Override
    public void delete() {
        this.creditAccount = null;
    }
}
