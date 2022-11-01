package tech.reliab.course.mikhaylyukovada.bank.service.impl;

import tech.reliab.course.mikhaylyukovada.bank.entity.BankOffice;
import tech.reliab.course.mikhaylyukovada.bank.service.BankOfficeService;

/**
 * Реализация интерфейса для взаимодействия с офисами
 */
public class BankOfficeServiceImpl extends ServiceImpl<BankOffice> implements BankOfficeService {

    public void create(Long id, String name, String address, Boolean isWorking, Boolean isPossibleToPlaceATM, Boolean isGettingLoan, Boolean isGettingMoney, Boolean isGivingMoney, Double rentPrice) {
        this.model = new BankOffice(id, name, address, isWorking, isPossibleToPlaceATM, isGettingLoan, isGettingMoney, isGivingMoney, rentPrice);
    }

    public void addAtm() {
        model.setAtmsNumber(model.getAtmsNumber() + 1);
    }
}
