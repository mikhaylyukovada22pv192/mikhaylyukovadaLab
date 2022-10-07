package tech.reliab.course.mikhaylyukovada.bank.entity;

/**
 * Модель банковского офиса
 */
public class BankOffice extends Bank {
    private Long id;
    private String name;
    private String address;
    private Boolean isWorking;
    private Boolean isPossibleToPlaceATM;
    private Integer atmsNumber;
    private Boolean isGettingLoan;
    private Boolean isGettingMoney;
    private Boolean isGivingMoney;
    private Double rentPrice;

    /**
     * Конструктор для создания модели банковского офиса
     *
     * @param bank банк
     * @param id id офиса
     * @param name название офиса
     * @param address адрес
     * @param isWorking работает ли офис
     * @param isPossibleToPlaceATM возможно ли разместить АТМ
     * @param atmsNumber количество АТМ
     * @param isGettingLoan возможно ли оформить кредит
     * @param isGettingMoney возможно ли снять деньги
     * @param isGivingMoney возможно ли положить деньги
     * @param rentPrice стоимость аренды
     */
    public BankOffice(Bank bank, Long id, String name, String address, Boolean isWorking, Boolean isPossibleToPlaceATM, Integer atmsNumber, Boolean isGettingLoan, Boolean isGettingMoney, Boolean isGivingMoney, Double rentPrice) {
        super(bank);
        this.id = id;
        this.name = name;
        this.address = address;
        this.isWorking = isWorking;
        this.isPossibleToPlaceATM = isPossibleToPlaceATM;
        this.atmsNumber = atmsNumber;
        this.isGettingLoan = isGettingLoan;
        this.isGettingMoney = isGettingMoney;
        this.isGivingMoney = isGivingMoney;
        this.rentPrice = rentPrice;
    }

    /**
     * @return возвращает id офиса
     */
    @Override
    public Long getId() {
        return id;
    }

    /**
     * @return возвращает название офиса
     */
    @Override
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
    @Override
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
        super.clearBank();
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
                ", isGettingLoan=" + isGettingLoan +
                ", isGettingMoney=" + isGettingMoney +
                ", isGivingMoney=" + isGivingMoney +
                ", rentPrice=" + rentPrice +
                '}';
    }
}
