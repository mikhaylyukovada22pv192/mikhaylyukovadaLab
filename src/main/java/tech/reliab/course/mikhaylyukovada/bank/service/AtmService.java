package tech.reliab.course.mikhaylyukovada.bank.service;

import tech.reliab.course.mikhaylyukovada.bank.entity.Bank;
import tech.reliab.course.mikhaylyukovada.bank.entity.BankAtm;
import tech.reliab.course.mikhaylyukovada.bank.entity.Employee;

public interface AtmService {

    void create(Bank bank, Long id, String name, Boolean isWorking, String location, Employee employee, Boolean isGivingMoney, Boolean isAcceptingMoney, Double maintenanceCost);

    BankAtm read();

    void update(BankAtm atm);

    void delete();

}
