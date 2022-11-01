package tech.reliab.course.mikhaylyukovada.bank.service;

import tech.reliab.course.mikhaylyukovada.bank.entity.CreditAccount;
import tech.reliab.course.mikhaylyukovada.bank.entity.Employee;
import tech.reliab.course.mikhaylyukovada.bank.entity.User;
import java.time.LocalDate;

/**
 * Интерфейс для взаимодействия с кредитными счетами
 */
public interface CreditAccountService extends Service<CreditAccount> {

    /**
     * Создает модель кредитного счета
     *
     * @param id id счета
     * @param user пользователь кредитного счета
     * @param bankName название банка
     * @param startDate дата начала
     * @param monthsNumber кол-во месяцев
     * @param creditAmount сумма кредита
     * @param interestRate процентная ставка
     * @param employee сотрудник, выдавший кредит
     * @param paymentAccount платежный счет
     */
    void create(Long id, User user, String bankName, LocalDate startDate, Integer monthsNumber, Double creditAmount, Double interestRate, Employee employee, String paymentAccount);

}
