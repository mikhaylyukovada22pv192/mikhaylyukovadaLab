package tech.reliab.course.mikhaylyukovada.bank.service;

import tech.reliab.course.mikhaylyukovada.bank.entity.BankOffice;
import tech.reliab.course.mikhaylyukovada.bank.service.common.BasicModelService;

/**
 * Интерфейс для взаимодействия с офисами
 */
public interface BankOfficeService extends BasicModelService<BankOffice> {

    /**
     * Добавляет новый банкомат в офис
     *
     * @param bankOfficeId id офиса
     */
    boolean addAtm(Long bankOfficeId);

    /**
     * Удаляет банкоматы офиса из банка
     *
     * @param bankOfficeId id офиса
     */
    boolean deleteAtm(Long bankOfficeId);

    /**
     * Добавляет нового сотрудника в офис
     *
     * @param bankOfficeId id офиса
     */
    boolean addEmployee(Long bankOfficeId);

    /**
     * Удаляет сотрудников офиса из банка
     *
     * @param bankOfficeId id офиса
     */
    boolean deleteEmployee(Long bankOfficeId);

}
