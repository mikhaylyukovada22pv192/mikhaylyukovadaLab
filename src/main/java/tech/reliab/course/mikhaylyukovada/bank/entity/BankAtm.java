package tech.reliab.course.mikhaylyukovada.bank.entity;

import tech.reliab.course.mikhaylyukovada.bank.entity.common.BankObject;

/**
 * Модель банкомата
 */
public class BankAtm extends BankObject {
    private BankOffice office;
    private String name;
    private Boolean isWorking;
    private String location;
    private Employee employee;
    private Boolean isGivingMoney;
    private Boolean isAcceptingMoney;
    private Double totalMoney;
    private Double maintenanceCost;

    /**
     * Конструктор для создания модели АТМ
     *
     * @param office банковский офис
     * @param name название банкомата
     * @param isWorking работает ли банкомат
     * @param location местоположение
     * @param employee обслуживающий сотрудник
     * @param isGivingMoney выдает ли деньги
     * @param isAcceptingMoney принимает ли деньги
     * @param totalMoney общее кол-во денег
     * @param maintenanceCost стоимость обслуживания
     */
    public BankAtm(String name, BankOffice office, Boolean isWorking, String location, Employee employee, Boolean isGivingMoney, Boolean isAcceptingMoney, Double totalMoney, Double maintenanceCost) {
        this.name = name;
        this.office = office;
        this.isWorking = isWorking;
        this.location = location;
        this.employee = employee;
        this.isGivingMoney = isGivingMoney;
        this.isAcceptingMoney = isAcceptingMoney;
        this.totalMoney = totalMoney;
        this.maintenanceCost = maintenanceCost;
    }

    /**
     * @return банковский офис
     */
    public BankOffice getOffice() {
        return office;
    }

    /**
     * @return название банкомата
     */
    public String getName() {
        return name;
    }

    /**
     * @return работает ли банкомат
     */
    public Boolean getWorking() {
        return isWorking;
    }

    /**
     * @return местоположение банкомата
     */
    public String getLocation() {
        return location;
    }

    /**
     * @return обслуживающего сотрудника
     */
    public Employee getEmployee() {
        return employee;
    }

    /**
     * @return выдает ли банкомат деньги
     */
    public Boolean getGivingMoney() {
        return isGivingMoney;
    }

    /**
     * @return принимает ли деньги
     */
    public Boolean getAcceptingMoney() {
        return isAcceptingMoney;
    }

    /**
     * @return общее кол-во денег
     */
    public Double getTotalMoney() {
        return totalMoney;
    }

    /**
     * @return стоимость обслуживания банкомата
     */
    public Double getMaintenanceCost() {
        return maintenanceCost;
    }

    /**
     * Задает банковский офис
     */
    public void setOffice(BankOffice office) {
        this.office = office;
    }

    /**
     * Задает название банкомата
     *
     * @param name название банкомата
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Задает работу банкомата
     *
     * @param isWorking работает ли банкомат
     */
    public void setWorking(Boolean isWorking) {
        this.isWorking = isWorking;
    }

    /**
     * Задает местоположение банкомата
     *
     * @param location местоположение
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * Задает обслуживающего сотрудника
     *
     * @param employee сотрудник
     */
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    /**
     * Задает выдачу денег в банкомате
     *
     * @param givingMoney банкомат выдает деньги
     */
    public void setGivingMoney(Boolean givingMoney) {
        isGivingMoney = givingMoney;
    }

    /**
     * Задает принятие денег банкоматом
     *
     * @param acceptingMoney банкомат принимает деньги
     */
    public void setAcceptingMoney(Boolean acceptingMoney) {
        isAcceptingMoney = acceptingMoney;
    }

    /**
     * Задает стоимость обслуживания
     *
     * @param maintenanceCost стоимость обслуживания
     */
    public void setMaintenanceCost(Double maintenanceCost) {
        this.maintenanceCost = maintenanceCost;
    }

    /**
     * Отчищает данные банкомата
     */
    public void clearBankAtm() {
        this.id = null;
        this.office = null;
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
