package tech.reliab.course.mikhaylyukovada.bank.service.impl;

import tech.reliab.course.mikhaylyukovada.bank.entity.Bank;
import tech.reliab.course.mikhaylyukovada.bank.entity.BankOffice;
import tech.reliab.course.mikhaylyukovada.bank.exceptions.IdNotFoundException;
import tech.reliab.course.mikhaylyukovada.bank.exceptions.WrongNameException;
import tech.reliab.course.mikhaylyukovada.bank.repository.BankOfficeRepository;
import tech.reliab.course.mikhaylyukovada.bank.service.BankOfficeService;
import tech.reliab.course.mikhaylyukovada.bank.service.BankService;

import java.util.List;

/**
 * Реализация интерфейса для взаимодействия с офисами
 */
public class BankOfficeServiceImpl implements BankOfficeService {
    private static BankOfficeServiceImpl INSTANCE;

    public static BankOfficeServiceImpl getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new BankOfficeServiceImpl();
        }

        return INSTANCE;
    }

    private final BankService bankService = BankServiceImpl.getInstance();
    private final BankOfficeRepository bankOfficeRepository = BankOfficeRepository.getInstance();

    @Override
    public BankOffice addObject(BankOffice bankOffice) {
        if (bankOffice.getName().isBlank()) {
            throw new WrongNameException();
        }

        BankOffice newBankOffice = bankOfficeRepository.add(bankOffice);
        Bank bank = bankService.getObjectById(bankOffice.getBank().getId());

        if (bank != null) {
            bank.setOfficesNumber(bank.getOfficesNumber() + 1);
            bankService.updateObject(bank);
        }

        return newBankOffice;
    }

    @Override
    public BankOffice updateObject(BankOffice bankOffice) {
        return bankOfficeRepository.update(bankOffice);
    }

    @Override
    public boolean deleteObjectById(Long id) {
        Long bankId = bankOfficeRepository.findById(id).getId();

        if (bankId == null) {
            throw new IdNotFoundException();
        }

        if (bankOfficeRepository.deleteById(id)) {
            Bank bank = bankService.getObjectById(bankId);

            if (bank != null && bank.getOfficesNumber() > 0) {
                bank.setOfficesNumber(bank.getOfficesNumber() - 1);
                bankService.updateObject(bank);

                return true;
            }
        }

        return false;
    }

    @Override
    public BankOffice getObjectById(Long id) {
        if (id == null) {
            throw new IdNotFoundException();
        }

        return bankOfficeRepository.findById(id);
    }

    @Override
    public List<BankOffice> getAllObjects() {
        return bankOfficeRepository.findAll();
    }

    @Override
    public boolean addAtm(Long bankOfficeId) {
        BankOffice bankOffice = bankOfficeRepository.findById(bankOfficeId);
        if (bankOffice != null) {
            Bank bank = bankService.getObjectById(bankOffice.getBank().getId());

            if (bank != null) {
                bank.setAtmsNumber(bank.getAtmsNumber() + 1);
                bankService.updateObject(bank);
                bankOffice.setAtmsNumber(bankOffice.getAtmsNumber() + 1);
                bankOfficeRepository.update(bankOffice);

                return true;
            }
        } else {
            throw new IdNotFoundException();
        }

        return false;
    }

    @Override
    public boolean deleteAtm(Long bankOfficeId) {
        var bankOffice = bankOfficeRepository.findById(bankOfficeId);
        if (bankOffice != null) {
            Bank bank = bankService.getObjectById(bankOffice.getBank().getId());

            if (bank != null && bank.getAtmsNumber() > 0 && bankOffice.getAtmsNumber() > 0) {
                bank.setAtmsNumber(bank.getAtmsNumber() - 1);
                bankService.updateObject(bank);
                bankOffice.setAtmsNumber(bankOffice.getAtmsNumber() - 1);
                bankOfficeRepository.update(bankOffice);

                return true;
            }
        } else {
            throw new IdNotFoundException();
        }

        return false;
    }


    @Override
    public boolean addEmployee(Long bankOfficeId) {
        BankOffice bankOffice = bankOfficeRepository.findById(bankOfficeId);

        if (bankOffice != null) {
            Bank bank = bankService.getObjectById(bankOffice.getBank().getId());

            if (bank != null) {
                bank.setEmployeesNumber(bank.getEmployeesNumber() + 1);
                bankService.updateObject(bank);

                return true;
            }
        } else {
            throw new IdNotFoundException();
        }

        return false;
    }


    @Override
    public boolean deleteEmployee(Long bankOfficeId) {
        BankOffice bankOffice = bankOfficeRepository.findById(bankOfficeId);
        if (bankOffice != null) {
            Bank bank = bankService.getObjectById(bankOffice.getBank().getId());

            if (bank != null && bank.getEmployeesNumber() > 0) {
                bank.setEmployeesNumber(bank.getEmployeesNumber() - 1);
                bankService.updateObject(bank);

                return true;
            }
        } else {
            throw new IdNotFoundException();
        }

        return false;
    }

    @Override
    public List<BankOffice> getAllBankOfficesByBankId(Long bankId) {
        return bankOfficeRepository.findAll().stream()
                .filter(bankOffice -> bankOffice.getBank().getId().compareTo(bankId) == 0)
                .toList();
    }
}
