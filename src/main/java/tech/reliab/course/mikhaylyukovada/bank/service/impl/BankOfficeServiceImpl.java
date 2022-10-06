package tech.reliab.course.mikhaylyukovada.bank.service.impl;

import tech.reliab.course.mikhaylyukovada.bank.entity.Bank;
import tech.reliab.course.mikhaylyukovada.bank.entity.BankOffice;
import tech.reliab.course.mikhaylyukovada.bank.service.BankOfficeService;

public class BankOfficeServiceImpl implements BankOfficeService {

    private BankOffice bankOffice = null;

    @Override
    public void create(Bank bank, Long id, String name, String address, Boolean isWorking, Boolean isPossibleToPlaceATM, Integer atmsNumber, Boolean isGettingLoan, Boolean isGettingMoney, Boolean isGivingMoney, Double rentPrice) {
        this.bankOffice = new BankOffice(bank, id, name, address, isWorking, isPossibleToPlaceATM, atmsNumber, isGettingLoan, isGettingMoney, isGivingMoney, rentPrice);
    }

    @Override
    public BankOffice read() {
        return bankOffice;
    }

    @Override
    public void update(BankOffice bankOffice) {
        this.bankOffice = bankOffice;
    }

    @Override
    public void delete() {
        this.bankOffice = null;
    }
}
