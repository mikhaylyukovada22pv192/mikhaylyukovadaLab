package tech.reliab.course.mikhaylyukovada.bank.service.impl;

import tech.reliab.course.mikhaylyukovada.bank.entity.BankAtm;
import tech.reliab.course.mikhaylyukovada.bank.entity.BankOffice;
import tech.reliab.course.mikhaylyukovada.bank.entity.Employee;
import tech.reliab.course.mikhaylyukovada.bank.service.AtmService;

/**
 * Реализация интерфейса для взаимодействия с банкоматами
 */
public class AtmServiceImpl implements AtmService {

    private BankAtm bankAtm = null;

    @Override
    public void create(BankOffice office, Long id, String name, Boolean isWorking, String location, Employee employee, Boolean isGivingMoney, Boolean isAcceptingMoney, Double maintenanceCost) {
        this.bankAtm = new BankAtm(id, office, name, isWorking, location, employee, isGivingMoney, isAcceptingMoney, maintenanceCost);
    }

    @Override
    public BankAtm read() {
        return bankAtm;
    }

    @Override
    public void update(BankAtm bankAtm) {
        this.bankAtm = bankAtm;
    }

    @Override
    public void delete() {
        this.bankAtm = null;
    }
}
