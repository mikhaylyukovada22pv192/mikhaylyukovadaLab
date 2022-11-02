package tech.reliab.course.mikhaylyukovada.bank.service.impl;

import tech.reliab.course.mikhaylyukovada.bank.entity.CreditAccount;
import tech.reliab.course.mikhaylyukovada.bank.entity.Employee;
import tech.reliab.course.mikhaylyukovada.bank.entity.User;
import tech.reliab.course.mikhaylyukovada.bank.service.CreditAccountService;
import java.time.LocalDate;

/**
 * Реализация интерфейса для взаимодействия с кредитными счетами
 */
public class CreditAccountServiceImpl extends ServiceImpl<CreditAccount> implements CreditAccountService {

    @Override
    public void create(Long id, User user, String bankName, LocalDate startDate, Integer monthsNumber, Double creditAmount, Double interestRate, Employee employee, String paymentAccount) {
        this.model = new CreditAccount(id, user, bankName, startDate, monthsNumber, creditAmount, interestRate, employee, paymentAccount);

        model.setCreditAmount(model.getCreditAmount() / model.getMonthsNumber().doubleValue() * model.getInterestRate());
        model.setEndDate(model.getStartDate().plusMonths(model.getMonthsNumber()));
    }
}
