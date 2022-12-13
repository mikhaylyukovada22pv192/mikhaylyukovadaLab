package tech.reliab.course.mikhaylyukovada.bank.entity;

import tech.reliab.course.mikhaylyukovada.bank.entity.common.BasicModel;

/**
 * Модель банковского офиса
 */
public class BankOffice extends BasicModel {
    private String name;
    private String address;
    private Bank bank;
    private Boolean isWorking;
    private Boolean isPossibleToPlaceATM;
    private Integer atmsNumber = 0;
    private Boolean isGettingLoan;
    private Boolean isGettingMoney;
    private Boolean isGivingMoney;
    private Double totalMoney;
    private Double rentPrice;

    public BankOffice() {}
    /**
     * Конструктор для создания модели банковского офиса
     *
     * @param name название офиса
     * @param address адрес
     * @param bank банк
     * @param isWorking работает ли офис
     * @param isPossibleToPlaceATM возможно ли разместить АТМ
     * @param isGettingLoan возможно ли оформить кредит
     * @param isGettingMoney возможно ли снять деньги
     * @param isGivingMoney возможно ли положить деньги
     * @param totalMoney общее кол-во денег
     * @param rentPrice стоимость аренды
     */
    public BankOffice(String name, String address, Bank bank, Boolean isWorking, Boolean isPossibleToPlaceATM, Boolean isGettingLoan, Boolean isGettingMoney, Boolean isGivingMoney, Double totalMoney, Double rentPrice) {
        this.name = name;
        this.address = address;
        this.bank = bank;
        this.isWorking = isWorking;
        this.isPossibleToPlaceATM = isPossibleToPlaceATM;
        this.isGettingLoan = isGettingLoan;
        this.isGettingMoney = isGettingMoney;
        this.isGivingMoney = isGivingMoney;
        this.totalMoney = totalMoney;
        this.rentPrice = rentPrice;
    }

    /**
     * @return возвращает название офиса
     */
    public String getName() {
        return name;
    }

    /**
     * @return возвращает адрес офиса
     */
    public String getAddress() {
        return address;
    }

    /**
     * @return банк, к которому относится офис
     */
    public Bank getBank() { return this.bank; }

    /**
     * @return работает ли офис
     */
    public Boolean getWorking() {
        return isWorking;
    }

    /**
     * @return можно ли разместить АТМ
     */
    public Boolean getPossibleToPlaceATM() {
        return isPossibleToPlaceATM;
    }

    /**
     * @return возвращает кол-во АТМ
     */
    public Integer getAtmsNumber() {
        return atmsNumber;
    }

    /**
     * @return возможно ли взять кредит
     */
    public Boolean getGettingLoan() {
        return isGettingLoan;
    }

    /**
     * @return возможно ли снять деньги
     */
    public Boolean getGettingMoney() {
        return isGettingMoney;
    }

    /**
     * @return возможно ли положить деньги
     */
    public Boolean getGivingMoney() {
        return isGivingMoney;
    }

    /**
     * @return кол-во денег в офисе
     */
    public Double getTotalMoney() {
        return totalMoney;
    }

    /**
     * @return стоимость аренды
     */
    public Double getRentPrice() {
        return rentPrice;
    }

    /**
     * Задает название офиса
     *
     * @param name название офиса
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Задает адрес офиса
     *
     * @param address адрес
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Задает работу офиса
     *
     * @param working работает ли офис
     */
    public void setWorking(Boolean working) {
        isWorking = working;
    }

    /**
     * Задает возможность разместить АТМ
     *
     * @param possibleToPlaceATM возможно ли разместить АТМ
     */
    public void setPossibleToPlaceATM(Boolean possibleToPlaceATM) {
        isPossibleToPlaceATM = possibleToPlaceATM;
    }

    /**
     * Задает кол-во АТМ
     *
     * @param atmsNumber кол-во АТМ
     */
    public void setAtmsNumber(Integer atmsNumber) {
        this.atmsNumber = atmsNumber;
    }

    /**
     * Задает возможность взять кредит
     *
     * @param gettingLoan возможно ли взять кредит
     */
    public void setGettingLoan(Boolean gettingLoan) {
        isGettingLoan = gettingLoan;
    }

    /**
     * Задает возможность снять деньги
     *
     * @param gettingMoney возможно ли снять деньги
     */
    public void setGettingMoney(Boolean gettingMoney) {
        isGettingMoney = gettingMoney;
    }

    /**
     * Задает возможность положить деньги
     *
     * @param givingMoney возможно ли положить деньги
     */
    public void setGivingMoney(Boolean givingMoney) {
        isGivingMoney = givingMoney;
    }

    /**
     * Задает кол-во денег в офисе
     *
     * @param totalMoney кол-во денег
     */
    public void setTotalMoney(Double totalMoney) {
        this.totalMoney = totalMoney;
    }

    /**
     * Задает стоимость аренды
     *
     * @param rentPrice стоимость аренды
     */
    public void setRentPrice(Double rentPrice) {
        this.rentPrice = rentPrice;
    }

    /**
     * Отчищает данные банковского офиса
     */
    public void clearBankOffice() {
        this.id = null;
        this.name = null;
        this.address = null;
        this.isWorking = null;
        this.isPossibleToPlaceATM = null;
        this.isGettingLoan = null;
        this.isGettingMoney = null;
        this.isGivingMoney = null;
        this.rentPrice = null;
    }

    @Override
    public String toString() {
        return "BankOffice{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", isWorking=" + isWorking +
                ", isPossibleToPlaceATM=" + isPossibleToPlaceATM +
                ", atmsNumber=" + atmsNumber +
                ", isGettingLoan=" + isGettingLoan +
                ", isGettingMoney=" + isGettingMoney +
                ", isGivingMoney=" + isGivingMoney +
                ", totalMoney=" + totalMoney +
                ", rentPrice=" + rentPrice +
                '}';
    }
}
