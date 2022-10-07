package tech.reliab.course.mikhaylyukovada.bank.service;

import tech.reliab.course.mikhaylyukovada.bank.entity.CreditAccount;
import tech.reliab.course.mikhaylyukovada.bank.entity.Employee;
import tech.reliab.course.mikhaylyukovada.bank.entity.User;

import java.time.LocalDate;

/**
 * Интерфейс для взаимодействия с кредитными счетами
 */
public interface CreditAccountService {

    /**
     * Создает модель кредитного счета
     *
     * @param id id счета
     * @param user пользователь кредитного счета
     * @param bankName название банка
     * @param startDate дата начала
     * @param endDate дата окончания
     * @param monthsNumber кол-во месяцев
     * @param creditAmount сумма кредита
     * @param monthlyPayment ежемесячный платеж
     * @param interestRate процентная ставка
     * @param employee сотрудник, выдавший кредит
     * @param paymentAccount платежный счет
     */
    void create(Long id, User user, String bankName, LocalDate startDate, LocalDate endDate, Integer monthsNumber, Double creditAmount, Double monthlyPayment, Double interestRate, Employee employee, String paymentAccount);

    /**
     * @return кредитный счет
     */
    CreditAccount read();

    /**
     * Обновляет кредитный счет
     *
     * @param creditAccount кредитный счет
     */
    void update(CreditAccount creditAccount);

    /**
     * Удаляет кредитный счет
     */
    void delete();
}
