package tech.reliab.course.mikhaylyukovada.bank.service;

import tech.reliab.course.mikhaylyukovada.bank.entity.CreditAccount;
import tech.reliab.course.mikhaylyukovada.bank.entity.Employee;
import tech.reliab.course.mikhaylyukovada.bank.entity.User;

import java.time.LocalDate;

public interface CreditAccountService {

    void create(Long id, User user, String bankName, LocalDate startDate, LocalDate endDate, Integer monthsNumber, Double creditAmount, Double monthlyPayment, Double interestRate, Employee employee, String paymentAccount);

    CreditAccount read();

    void update(CreditAccount creditAccount);

    void delete();
}
