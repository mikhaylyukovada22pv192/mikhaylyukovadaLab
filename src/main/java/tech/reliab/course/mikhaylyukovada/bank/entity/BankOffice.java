package tech.reliab.course.mikhaylyukovada.bank.entity;

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

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public Boolean getWorking() {
        return isWorking;
    }

    public Boolean getPossibleToPlaceATM() {
        return isPossibleToPlaceATM;
    }

    public Integer getAtmsNumber() {
        return atmsNumber;
    }

    public Boolean getGettingLoan() {
        return isGettingLoan;
    }

    public Boolean getGettingMoney() {
        return isGettingMoney;
    }

    public Boolean getGivingMoney() {
        return isGivingMoney;
    }

    public Double getRentPrice() {
        return rentPrice;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setWorking(Boolean working) {
        isWorking = working;
    }

    public void setPossibleToPlaceATM(Boolean possibleToPlaceATM) {
        isPossibleToPlaceATM = possibleToPlaceATM;
    }

    public void setAtmsNumber(Integer atmsNumber) {
        this.atmsNumber = atmsNumber;
    }

    public void setGettingLoan(Boolean gettingLoan) {
        isGettingLoan = gettingLoan;
    }

    public void setGettingMoney(Boolean gettingMoney) {
        isGettingMoney = gettingMoney;
    }

    public void setGivingMoney(Boolean givingMoney) {
        isGivingMoney = givingMoney;
    }

    public void setRentPrice(Double rentPrice) {
        this.rentPrice = rentPrice;
    }

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
