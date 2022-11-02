package tech.reliab.course.mikhaylyukovada.bank.service.impl;

import tech.reliab.course.mikhaylyukovada.bank.entity.BankAtm;
import tech.reliab.course.mikhaylyukovada.bank.entity.BankOffice;
import tech.reliab.course.mikhaylyukovada.bank.entity.Employee;
import tech.reliab.course.mikhaylyukovada.bank.service.AtmService;
import tech.reliab.course.mikhaylyukovada.bank.service.BankOfficeService;

/**
 * Реализация интерфейса для взаимодействия с банкоматами
 */
public class AtmServiceImpl extends ServiceImpl<BankAtm> implements AtmService {

    private BankOfficeService bankOfficeService;

    public AtmServiceImpl(BankOfficeService bankOfficeService) {
        this.bankOfficeService = bankOfficeService;
    }

    @Override
    public void create(BankOffice office, Long id, String name, Boolean isWorking, String location, Employee employee, Boolean isGivingMoney, Boolean isAcceptingMoney, Double maintenanceCost) {
        this.model = new BankAtm(id, office, name, isWorking, location, employee, isGivingMoney, isAcceptingMoney, maintenanceCost);
        bankOfficeService.addAtm();
    }
}
