package tech.reliab.course.mikhaylyukovada.bank.service.impl;

import tech.reliab.course.mikhaylyukovada.bank.entity.Bank;
import tech.reliab.course.mikhaylyukovada.bank.entity.User;
import tech.reliab.course.mikhaylyukovada.bank.repository.CreditAccountRepository;
import tech.reliab.course.mikhaylyukovada.bank.repository.PaymentAccountRepository;
import tech.reliab.course.mikhaylyukovada.bank.repository.UserRepository;
import tech.reliab.course.mikhaylyukovada.bank.service.BankService;
import tech.reliab.course.mikhaylyukovada.bank.service.UserService;
import java.util.List;

/**
 * Реализация интерфейса для взаимодействия с пользователями
 */
public class UserServiceImpl implements UserService {
    private static UserServiceImpl INSTANCE;

    public static UserServiceImpl getInstance() {
        if (INSTANCE == null) { INSTANCE = new UserServiceImpl(); }

        return INSTANCE;
    }

    private final UserRepository userRepository = UserRepository.getInstance();
    private final BankService bankService = BankServiceImpl.getInstance();

    @Override
    public User addObject(User user) {
        User newUser = userRepository.add(user);
        List<Bank> banks = user.getBanks();

        for (var bank : banks) {
            var oneBank = bankService.getObjectById(bank.getId());
            oneBank.setClientsNumber(oneBank.getClientsNumber() + 1);
            bankService.updateObject(oneBank);
        }

        return newUser;
    }

    @Override
    public User updateObject(User user) {
        return userRepository.update(user);
    }

    @Override
    public boolean deleteObjectById(Long id) {
        var user = userRepository.findById(id);

        if (user != null) {
            userRepository.deleteById(id);
            List<Bank> banks = user.getBanks();
            for (var bank : banks) {
                var oneBank = bankService.getObjectById(bank.getId());
                oneBank.setClientsNumber(oneBank.getClientsNumber() - 1);
                bankService.updateObject(oneBank);
            }

            return true;
        }

        return false;
    }

    @Override
    public User getObjectById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public List<User> getAllObjects() {
        return userRepository.findAll();
    }

    @Override
    public void outputUserAccounts(Long userId) {
        PaymentAccountRepository paymentAccountRepository = PaymentAccountRepository.getInstance();
        CreditAccountRepository creditAccountRepository = CreditAccountRepository.getInstance();

        System.out.println(userRepository.findById(userId).getName());

        var paymentAccounts = paymentAccountRepository.findAll().stream()
                .filter(paymentAccount -> paymentAccount.getUser().getId().compareTo(userId) == 0)
                .toList();

        if (paymentAccounts.size() > 0) {
            System.out.println("Payment accounts ");
            for (var paymentAccount : paymentAccounts) {
                System.out.println(paymentAccount);

            }
        }

        var creditAccounts = creditAccountRepository.findAll().stream()
                .filter(creditAccount ->
                        creditAccount.getUser().getId().compareTo(userId) == 0
                )
                .toList();

        if (creditAccounts.size() > 0) {
            System.out.println("Credit accounts ");
            for (var creditAccount : creditAccounts) {
                System.out.println(creditAccount);
            }
        }
    }
}
