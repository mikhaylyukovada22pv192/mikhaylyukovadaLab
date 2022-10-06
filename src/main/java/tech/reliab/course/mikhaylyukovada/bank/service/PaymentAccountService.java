package tech.reliab.course.mikhaylyukovada.bank.service;

import tech.reliab.course.mikhaylyukovada.bank.entity.PaymentAccount;
import tech.reliab.course.mikhaylyukovada.bank.entity.User;

import java.time.LocalDate;

public interface PaymentAccountService {

    void create(Long id, User user, String bankName);

    PaymentAccount read();

    void update(PaymentAccount paymentAccount);

    void delete();
}
