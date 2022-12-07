package tech.reliab.course.mikhaylyukovada.bank.service;

import tech.reliab.course.mikhaylyukovada.bank.entity.BankAtm;
import java.util.List;
import tech.reliab.course.mikhaylyukovada.bank.service.common.BasicModelService;

/**
 * Интерфейс для взаимодействия с банкоматами
 */
public interface AtmService extends BasicModelService<BankAtm> {

    /**
     * Возвращает все бакноматы, которые хранятся в репозитории, принадлежащие офису officeId.
     */
    List<BankAtm> getAllBankAtmsByOffice(Long officeId);

    /**
     * Возвраащет true при успешном снятии денег
     *
     * @param id id банка
     * @param money запрашиваемая сумма денег
     */
    boolean withdrawMoney(Long id, Double money);
}
