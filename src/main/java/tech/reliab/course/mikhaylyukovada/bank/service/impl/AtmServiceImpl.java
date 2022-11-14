package tech.reliab.course.mikhaylyukovada.bank.service.impl;

import tech.reliab.course.mikhaylyukovada.bank.entity.BankAtm;
import tech.reliab.course.mikhaylyukovada.bank.entity.BankOffice;
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
        if (INSTANCE == null) { INSTANCE = new AtmServiceImpl(); }

        return INSTANCE;
    }

    private final AtmRepositoryBank bankAtmRepository = AtmRepositoryBank.getInstance();
    private final BankOfficeService bankOfficeService = BankOfficeServiceImpl.getInstance();

    @Override
    public BankAtm addObject(BankAtm bankAtm) {
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

        if (bankAtmRepository.deleteById(id)) {
            return bankOfficeService.deleteAtm(officeId);
        }
        return false;
    }

    @Override
    public BankAtm getObjectById(Long id) {
        return bankAtmRepository.findById(id);
    }

    @Override
    public List<BankAtm> getAllObjects() {
        return bankAtmRepository.findAll();
    }
}
