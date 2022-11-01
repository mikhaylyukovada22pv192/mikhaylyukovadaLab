package tech.reliab.course.mikhaylyukovada.bank.service.impl;

import tech.reliab.course.mikhaylyukovada.bank.entity.Bank;
import tech.reliab.course.mikhaylyukovada.bank.service.BankService;

/**
 * Реализация интерфейса для взаимодействия с банками
 */
public class BankServiceImpl extends ServiceImpl<Bank> implements BankService {

    public void create(Long id, String name) {
        this.model = new Bank(id, name);
    }

    public void addOffice() {
        this.model.addOffice();
    }

    public void addAtm() {
        this.model.addAtm();
    }

    public void addEmployee() {
        this.model.addEmployee();
    }

    public void addClient() {
        this.model.addClient();
    }
}
