package tech.reliab.course.mikhaylyukovada.bank.service;

import tech.reliab.course.mikhaylyukovada.bank.entity.Bank;
import tech.reliab.course.mikhaylyukovada.bank.entity.BankOffice;

public interface BankOfficeService {

    void create(Bank bank, Long id, String name, String address, Boolean isWorking, Boolean isPossibleToPlaceATM, Integer atmsNumber, Boolean isGettingLoan, Boolean isGettingMoney, Boolean isGivingMoney, Double rentPrice);

    BankOffice read();

    void update(BankOffice bankOffice);

    void delete();

}
