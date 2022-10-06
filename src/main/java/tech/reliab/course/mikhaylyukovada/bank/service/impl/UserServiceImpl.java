package tech.reliab.course.mikhaylyukovada.bank.service.impl;

import tech.reliab.course.mikhaylyukovada.bank.entity.Bank;
import tech.reliab.course.mikhaylyukovada.bank.entity.User;
import tech.reliab.course.mikhaylyukovada.bank.service.UserService;

import java.time.LocalDate;

public class UserServiceImpl implements UserService {

    private User user = null;

    @Override
    public void create(Long id, String name, LocalDate birthDate, String workPlace, Bank bank) {
        this.user = new User(id, name, birthDate, workPlace, bank);
    }

    @Override
    public User read() {
        return user;
    }

    @Override
    public void update(User user) {
        this.user = user;
    }

    @Override
    public void delete() {
        this.user = null;
    }
}
