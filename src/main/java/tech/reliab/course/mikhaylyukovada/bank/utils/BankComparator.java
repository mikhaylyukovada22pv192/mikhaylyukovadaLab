package tech.reliab.course.mikhaylyukovada.bank.utils;

import tech.reliab.course.mikhaylyukovada.bank.entity.Bank;

import java.util.Comparator;
import java.util.Objects;

/**
 * Компоратор для сортировки банков от худшего к лучшему
 */
public class BankComparator implements Comparator<Bank> {
    @Override
    public int compare(Bank left, Bank right) {
        if (!Objects.equals(left.getAtmsNumber(), right.getAtmsNumber())) {
            return left.getAtmsNumber() > right.getAtmsNumber() ? 1 : -1;
        }

        if (!Objects.equals(left.getEmployeesNumber(), right.getEmployeesNumber())) {
            return left.getEmployeesNumber() > right.getEmployeesNumber() ? 1 : -1;
        }

        if (!Objects.equals(left.getOfficesNumber(), right.getOfficesNumber())) {
            return left.getOfficesNumber() > right.getOfficesNumber() ? 1 : -1;
        }

        if (!Objects.equals(left.getClientsNumber(), right.getClientsNumber())) {
            return left.getClientsNumber() > right.getClientsNumber() ? 1 : -1;
        }

        if (!Objects.equals(left.getBankRating(), right.getBankRating())) {
            return left.getBankRating() > right.getBankRating() ? 1 : -1;
        }

        if (!Objects.equals(left.getInterestRate(), right.getInterestRate())) {
            return left.getInterestRate() < right.getInterestRate() ? 1 : -1;
        }

        return 0;
    }
}
