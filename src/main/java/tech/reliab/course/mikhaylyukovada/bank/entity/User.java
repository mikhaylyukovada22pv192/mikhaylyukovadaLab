package tech.reliab.course.mikhaylyukovada.bank.entity;

import tech.reliab.course.mikhaylyukovada.bank.entity.common.Person;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Модель пользователя
 */
public class User extends Person {
    private String workPlace;
    private Double monthlyIncome;
    private List<Bank> banks = new ArrayList<>();
    private CreditAccount creditAccount = null;
    private PaymentAccount paymentAccount = null;
    private Double creditRating;

    /**
     * Конструктор для создания модели пользователя
     *
     * @param name имя пользователя
     * @param birthDate дата рождения
     * @param workPlace место работы
     * @param bank банк, которым пользуется
     */
    public User(String name, LocalDate birthDate, String workPlace, Bank bank, Double monthlyIncome, Double creditRating) {
        super(name, birthDate);
        this.workPlace = workPlace;
        this.banks.add(bank);
        this.monthlyIncome = monthlyIncome;
        this.creditRating = creditRating;
    }

    /**
     * @return место работы
     */
    public String getWorkPlace() {
        return workPlace;
    }

    /**
     * @return ежемесячный доход
     */
    public Double getMonthlyIncome() {
        return monthlyIncome;
    }

    /**
     * @return банк, которым пользуется
     */
    public List<Bank> getBanks() {
        return banks;
    }

    /**
     * @return кредитный счет
     */
    public CreditAccount getCreditAccount() {
        return creditAccount;
    }

    /**
     * @return платежный счет
     */
    public PaymentAccount getPaymentAccount() {
        return paymentAccount;
    }

    /**
     * @return крежитный рейтинг
     */
    public Double getCreditRating() {
        return creditRating;
    }

    /**
     * Задает место работы
     *
     * @param workPlace место работы
     */
    public void setWorkPlace(String workPlace) {
        this.workPlace = workPlace;
    }

    /**
     * Задает банк, которым пользуется клиент
     *
     * @param bank банк
     */
    public void addBank(Bank bank) {
        this.banks.add(bank);
    }

    /**
     * Задает кредитный счет
     *
     * @param creditAccount счет
     */
    public void setCreditAccount(CreditAccount creditAccount) {
        this.creditAccount = creditAccount;
    }

    /**
     * Задает платежный счет
     *
     * @param paymentAccount счет
     */
    public void setPaymentAccount(PaymentAccount paymentAccount) {
        this.paymentAccount = paymentAccount;
    }

    /**
     * Задает кредитный рейтинг
     *
     * @param creditRating кредитный рейтинг
     */
    public void setCreditRating(Double creditRating) {
        this.creditRating = creditRating;
    }

    /**
     * Отчищает данные пользователя
     */
    public void clearUser() {
        this.id = null;
        this.name = null;
        this.birthDate = null;
        this.workPlace = null;
        this.monthlyIncome = null;
        this.banks = null;
        this.creditAccount = null;
        this.paymentAccount = null;
        this.creditRating = null;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", birthDate=" + birthDate +
                ", workPlace='" + workPlace + '\'' +
                ", monthlyIncome=" + monthlyIncome +
                ", bank=" + banks.stream().map(Bank::getName).toList() +
                //", creditAccount=" + creditAccount.toString() +
                //", paymentAccount=" + paymentAccount.toString() +
                ", creditRating=" + creditRating +
                '}';
    }
}
