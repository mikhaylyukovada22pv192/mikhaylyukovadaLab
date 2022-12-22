package tech.reliab.course.mikhaylyukovada.bank.service.impl;

import tech.reliab.course.mikhaylyukovada.bank.entity.BankAtm;
import tech.reliab.course.mikhaylyukovada.bank.entity.BankOffice;
import tech.reliab.course.mikhaylyukovada.bank.exceptions.IdNotFoundException;
import tech.reliab.course.mikhaylyukovada.bank.exceptions.ErrorSumException;
import tech.reliab.course.mikhaylyukovada.bank.exceptions.WrongNameException;
import tech.reliab.course.mikhaylyukovada.bank.repository.AtmRepositoryBank;
import tech.reliab.course.mikhaylyukovada.bank.service.AtmService;
import tech.reliab.course.mikhaylyukovada.bank.service.BankOfficeService;
import java.util.List;

/**
 * Реализация интерфейса для взаимодействия с банкоматами
 */
public class AtmServiceImpl implements AtmService {
    private static AtmServiceImpl INSTANCE;

    public static AtmServiceImpl getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new AtmServiceImpl();
        }

        return INSTANCE;
    }

    private final AtmRepositoryBank bankAtmRepository = AtmRepositoryBank.getInstance();
    private final BankOfficeService bankOfficeService = BankOfficeServiceImpl.getInstance();

    @Override
    public BankAtm addObject(BankAtm bankAtm) {
        if (bankAtm.getName().isBlank()) {
            throw new WrongNameException();
        }

        BankAtm newBankAtm = bankAtmRepository.add(bankAtm);
        BankOffice office = newBankAtm.getOffice();

        if (office != null) {
            bankOfficeService.addAtm(office.getId());
        }
        return newBankAtm;
    }

    @Override
    public BankAtm updateObject(BankAtm bankAtm) {
        return null;
    }

    @Override
    public boolean deleteObjectById(Long id) {
        Long officeId = bankAtmRepository.findById(id).getId();

        if (officeId == null) {
            throw new IdNotFoundException();
        }

        if (bankAtmRepository.deleteById(id)) {
            return bankOfficeService.deleteAtm(officeId);
        }
        return false;
    }

    @Override
    public BankAtm getObjectById(Long id) {
        if (id == null) {
            throw new IdNotFoundException();
        }

        return bankAtmRepository.findById(id);
    }

    @Override
    public List<BankAtm> getAllObjects() {
        return bankAtmRepository.findAll();
    }

    @Override
    public List<BankAtm> getAllBankAtmsByOffice(Long officeId) {
        return bankAtmRepository.findAll().stream()
                .filter(atm -> atm.getOffice().getId().compareTo(officeId) == 0)
                .toList();
    }

    @Override
    public boolean withdrawMoney(Long id, Double money) {
        if (money <= 0) {
            throw new ErrorSumException();
        }
        var bankAtm = bankAtmRepository.findById(id);

        if (bankAtm == null) {
            throw new IdNotFoundException();
        }

        if (bankAtm.getAcceptingMoney() && money.compareTo(bankAtm.getTotalMoney()) < 0) {
            bankAtm.setTotalMoney(bankAtm.getTotalMoney() - money);
            bankAtmRepository.update(bankAtm);
            return true;
        }

        return false;
    }
}
