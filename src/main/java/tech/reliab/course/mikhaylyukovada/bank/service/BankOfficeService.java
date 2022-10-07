package tech.reliab.course.mikhaylyukovada.bank.service;

import tech.reliab.course.mikhaylyukovada.bank.entity.Bank;
import tech.reliab.course.mikhaylyukovada.bank.entity.BankOffice;

/**
 * Интерфейс для взаимодействия с офисами
 */
public interface BankOfficeService {

    /**
     * Созадет модель офиса
     *
     * @param bank банк
     * @param id id офиса
     * @param name название офиса
     * @param address адрес
     * @param isWorking работает ли офис
     * @param isPossibleToPlaceATM возможно ли разместить АТМ
     * @param atmsNumber количество АТМ
     * @param isGettingLoan возможно ли оформить кредит
     * @param isGettingMoney возможно ли снять деньги
     * @param isGivingMoney возможно ли положить деньги
     * @param rentPrice стоимость аренды
     */
    void create(Bank bank, Long id, String name, String address, Boolean isWorking, Boolean isPossibleToPlaceATM, Integer atmsNumber, Boolean isGettingLoan, Boolean isGettingMoney, Boolean isGivingMoney, Double rentPrice);

    /**
     * @return модель офиса
     */
    BankOffice read();

    /**
     * Обновляет модель офиса
     *
     * @param bankOffice офис
     */
    void update(BankOffice bankOffice);

    /**
     * Удаляет модель офиса
     */
    void delete();

}
