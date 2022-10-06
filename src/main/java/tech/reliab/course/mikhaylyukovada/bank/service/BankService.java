package tech.reliab.course.mikhaylyukovada.bank.service;

import tech.reliab.course.mikhaylyukovada.bank.entity.Bank;

public interface BankService {

    void create(Long id, String name);

    Bank read();

    void update(Bank bank);

    void delete();

}
