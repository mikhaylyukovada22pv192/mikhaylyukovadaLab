package tech.reliab.course.mikhaylyukovada.bank.entity;

import tech.reliab.course.mikhaylyukovada.bank.entity.models.Person;
import java.time.LocalDate;
import java.util.Random;

/**
 * Модель пользователя
 */
public class User extends Person {
    private String workPlace;
    private Double monthlyIncome;
    private Bank bank;
    private CreditAccount creditAccount = null;
    private PaymentAccount paymentAccount = null;
    private Double creditRating;

    /**
     * Конструктор для создания модели пользователя
     *
     * @param id id пользователя
     * @param name имя пользователя
     * @param birthDate дата рождения
     * @param workPlace место работы
     * @param bank банк, которым пользуется
     */
    public User(Long id, String name, LocalDate birthDate, String workPlace, Bank bank) {
        super(id, name, birthDate);
        this.workPlace = workPlace;
        this.bank = bank;

        Random rand = new Random();
        this.monthlyIncome = rand.nextDouble(10000) + 100;
        this.creditRating = this.monthlyIncome % 100;
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
    public Bank getBank() {
        return bank;
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
    public void setBank(Bank bank) {
        this.bank = bank;
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
     * Отчищает данные пользователя
     */
    public void clearUser() {
        this.id = null;
        this.name = null;
        this.birthDate = null;
        this.workPlace = null;
        this.monthlyIncome = null;
        this.bank = null;
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
                ", bank=" + bank.getName() +
                ", creditAccount=" + creditAccount.toString() +
                ", paymentAccount=" + paymentAccount.toString() +
                ", creditRating=" + creditRating +
                '}';
    }
}
