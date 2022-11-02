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
        model.addOffice();
    }

    @Override
    public void addAtm() {
        model.addAtm();
    }

    @Override
    public void addEmployee() {
        model.addEmployee();
    }

    @Override
    public void addClient() {
        model.addClient();
    }
}
