package tech.reliab.course.mikhaylyukovada.bank.entity;

/**
 * Модель банкомата
 */
public class BankAtm extends Bank {
    private Long id;
    private String name;
    private Boolean isWorking;
    private String location;
    private Employee employee;
    private Boolean isGivingMoney;
    private Boolean isAcceptingMoney;
    private Double maintenanceCost;

    public BankAtm(Bank bank, Long id, String name, Boolean isWorking, String location, Employee employee, Boolean isGivingMoney, Boolean isAcceptingMoney, Double maintenanceCost) {
        super(bank);
        this.id = id;
        this.name = name;
        this.isWorking = isWorking;
        this.location = location;
        this.employee = employee;
        this.isGivingMoney = isGivingMoney;
        this.isAcceptingMoney = isAcceptingMoney;
        this.maintenanceCost = maintenanceCost;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    public Boolean getWorking() {
        return isWorking;
    }

    public String getLocation() {
        return location;
    }

    public Employee getEmployee() {
        return employee;
    }

    public Boolean getGivingMoney() {
        return isGivingMoney;
    }

    public Boolean getAcceptingMoney() {
        return isAcceptingMoney;
    }

    public Double getMaintenanceCost() {
        return maintenanceCost;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public void setWorking(Boolean isWorking) {
        this.isWorking = isWorking;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public void setGivingMoney(Boolean givingMoney) {
        isGivingMoney = givingMoney;
    }

    public void setAcceptingMoney(Boolean acceptingMoney) {
        isAcceptingMoney = acceptingMoney;
    }

    public void setMaintenanceCost(Double maintenanceCost) {
        this.maintenanceCost = maintenanceCost;
    }

    public void clearBankAtm() {
        super.clearBank();
        this.id = null;
        this.name = null;
        this.isWorking = null;
        this.location = null;
        this.employee = null;
        this.isGivingMoney = null;
        this.isAcceptingMoney = null;
        this.maintenanceCost = null;
    }

    @Override
    public String toString() {
        return "BankAtm{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", isWorking=" + isWorking +
                ", location='" + location + '\'' +
                ", employee=" + employee +
                ", isGivingMoney=" + isGivingMoney +
                ", isAcceptingMoney=" + isAcceptingMoney +
                ", maintenanceCost=" + maintenanceCost +
                '}';
    }
}
