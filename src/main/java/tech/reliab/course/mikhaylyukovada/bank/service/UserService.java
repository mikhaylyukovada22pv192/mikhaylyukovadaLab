package tech.reliab.course.mikhaylyukovada.bank.service;

import tech.reliab.course.mikhaylyukovada.bank.entity.Bank;
import tech.reliab.course.mikhaylyukovada.bank.entity.User;

import java.time.LocalDate;

public interface UserService {

    void create(Long id, String name, LocalDate birthDate, String workPlace, Bank bank);

    User read();

    void update(User user);

    void delete();
}
