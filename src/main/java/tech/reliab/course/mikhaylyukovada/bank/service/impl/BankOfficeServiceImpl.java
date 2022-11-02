package tech.reliab.course.mikhaylyukovada.bank.service.impl;

import tech.reliab.course.mikhaylyukovada.bank.entity.BankOffice;
import tech.reliab.course.mikhaylyukovada.bank.service.BankOfficeService;
import tech.reliab.course.mikhaylyukovada.bank.service.BankService;

/**
 * Реализация интерфейса для взаимодействия с офисами
 */
public class BankOfficeServiceImpl extends ServiceImpl<BankOffice> implements BankOfficeService {

    private BankService bankService;

    public BankOfficeServiceImpl(BankService bankService) {
        this.bankService = bankService;
    }

    @Override
    public void create(Long id, String name, String address, Boolean isWorking, Boolean isPossibleToPlaceATM, Boolean isGettingLoan, Boolean isGettingMoney, Boolean isGivingMoney, Double rentPrice) {
        this.model = new BankOffice(id, name, address, isWorking, isPossibleToPlaceATM, isGettingLoan, isGettingMoney, isGivingMoney, rentPrice);

        model.setTotalMoney(this.bankService.read().getTotalMoney());
        bankService.addOffice();
    }

    @Override
    public void addAtm() {
        model.setAtmsNumber(this.model.getAtmsNumber() + 1);
        bankService.addAtm();
    }

    @Override
    public void addEmployee() {
        bankService.addEmployee();
    }
}
