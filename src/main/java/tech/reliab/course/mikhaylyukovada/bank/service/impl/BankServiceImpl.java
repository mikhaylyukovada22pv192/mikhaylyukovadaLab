package tech.reliab.course.mikhaylyukovada.bank.service.impl;

import tech.reliab.course.mikhaylyukovada.bank.entity.Bank;
import tech.reliab.course.mikhaylyukovada.bank.service.BankService;

/**
 * Реализация интерфейса для взаимодействия с банками
 */
public class BankServiceImpl implements BankService {

    private Bank bank = null;

    @Override
    public void create(Long id, String name) {
        this.bank = new Bank(id, name);
    }

    @Override
    public Bank read() {
        return bank;
    }

    @Override
    public void update(Bank bank) {
        this.bank = bank;
    }

    @Override
    public void delete() {
        this.bank = null;
    }

    public void addOffice() {
        this.bank.addOffice();
    }

    public void addAtm() {
        this.bank.addAtm();
    }

    public void addEmployee() {
        this.bank.addEmployee();
    }

    public void addClient() {
        this.bank.addClient();
    }
}
