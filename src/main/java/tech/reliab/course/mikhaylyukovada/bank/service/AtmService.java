package tech.reliab.course.mikhaylyukovada.bank.service;

import tech.reliab.course.mikhaylyukovada.bank.entity.Bank;
import tech.reliab.course.mikhaylyukovada.bank.entity.BankAtm;
import tech.reliab.course.mikhaylyukovada.bank.entity.Employee;

/**
 * Интерфейс для взаимодействия с банкоматами
 */
public interface AtmService {

    /**
     * Создает модель банкомата
     *
     * @param bank банк
     * @param id id банкомата
     * @param name название банкомата
     * @param isWorking работает ли банкомат
     * @param location местоположение
     * @param employee обслуживающий сотрудник
     * @param isGivingMoney выдает ли деньги
     * @param isAcceptingMoney принимает ли деньги
     * @param maintenanceCost стоимость обслуживания
     */
    void create(Bank bank, Long id, String name, Boolean isWorking, String location, Employee employee, Boolean isGivingMoney, Boolean isAcceptingMoney, Double maintenanceCost);

    /**
     * @return модель банкомата
     */
    BankAtm read();

    /**
     * Обновляет модель банкомата
     *
     * @param atm банкомат
     */
    void update(BankAtm atm);

    /**
     * Удаляет модель банкомата
     */
    void delete();

}
