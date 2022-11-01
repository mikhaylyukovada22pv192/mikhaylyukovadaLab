package tech.reliab.course.mikhaylyukovada.bank.service.impl;

import tech.reliab.course.mikhaylyukovada.bank.entity.Bank;
import tech.reliab.course.mikhaylyukovada.bank.entity.User;
import tech.reliab.course.mikhaylyukovada.bank.service.BankService;
import tech.reliab.course.mikhaylyukovada.bank.service.UserService;

import java.time.LocalDate;

/**
 * Реализация интерфейса для взаимодействия с пользователями
 */
public class UserServiceImpl extends ServiceImpl<User> implements UserService {

    private BankService bankService;

    public UserServiceImpl(BankService bankService) {
        this.bankService = bankService;
    }

    @Override
    public void create(Long id, String name, LocalDate birthDate, String workPlace, Bank bank) {
        this.model = new User(id, name, birthDate, workPlace, bank);
        this.bankService.addClient();
    }
}
