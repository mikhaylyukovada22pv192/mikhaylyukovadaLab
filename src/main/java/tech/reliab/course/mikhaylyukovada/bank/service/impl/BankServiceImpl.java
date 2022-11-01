package tech.reliab.course.mikhaylyukovada.bank.service.impl;

import tech.reliab.course.mikhaylyukovada.bank.entity.Bank;
import tech.reliab.course.mikhaylyukovada.bank.service.BankService;

/**
 * Реализация интерфейса для взаимодействия с банками
 */
public class BankServiceImpl extends ServiceImpl<Bank> implements BankService {

    @Override
    public void create(Long id, String name) {
        this.model = new Bank(id, name);
    }

    @Override
    public void addOffice() {
        this.model.addOffice();
    }

    @Override
    public void addAtm() {
        this.model.addAtm();
    }

    @Override
    public void addEmployee() {
        this.model.addEmployee();
    }

    @Override
    public void addClient() {
        this.model.addClient();
    }
}
