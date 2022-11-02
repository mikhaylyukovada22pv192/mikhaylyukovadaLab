package tech.reliab.course.mikhaylyukovada.bank.service;

import tech.reliab.course.mikhaylyukovada.bank.entity.BankAtm;
import tech.reliab.course.mikhaylyukovada.bank.entity.BankOffice;
import tech.reliab.course.mikhaylyukovada.bank.entity.Employee;

/**
 * Интерфейс для взаимодействия с банкоматами
 */
public interface AtmService extends Service<BankAtm> {

    /**
     * Создает модель банкомата
     *
     * @param id id банкомата
     * @param office банковский офис
     * @param name название банкомата
     * @param isWorking работает ли банкомат
     * @param location местоположение
     * @param employee обслуживающий сотрудник
     * @param isGivingMoney выдает ли деньги
     * @param isAcceptingMoney принимает ли деньги
     * @param maintenanceCost стоимость обслуживания
     */
    void create(BankOffice office, Long id, String name, Boolean isWorking, String location, Employee employee, Boolean isGivingMoney, Boolean isAcceptingMoney, Double maintenanceCost);

}
