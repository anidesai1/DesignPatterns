package strategy;

import templatemethodpattern.Address;

import java.time.LocalDate;

public abstract class Employee {
    String name;
    Address address;
    LocalDate birthday;
    double payRate;
    UnionDuesStrategy myUnionDuesStrategy = new NoUnionDuesStrategy();
    SocialSecurityTaxesStrategy mySecurityTaxesStrategy = new SocialSecurityTaxes();
    StateTaxesStrategy myStateTaxesStrategy = new StateTaxes();
    FederalTaxesStrategy myFederalTaxesStrategy = new FederalTaxes();

    double yearToDateEarnings = 0;

    public double computeNetPay() {
        double periodPay = 0;
        double annualPay = 0;
        int payFrequency = 0;
        double netPay = 0;

        periodPay = getPeriodPay(periodPay);
        payFrequency = getPayFrequency();
        annualPay = periodPay*payFrequency;

        double federalTaxes = calculateFederalTaxes(annualPay, payFrequency);
        double stateTaxes = calculateStateTaxes(periodPay);
        double socialSecurityTaxes = calculateSocialSecurityTaxes(periodPay);
        double unionDues = calculateUnionDues(periodPay);

        netPay = periodPay - federalTaxes - stateTaxes - socialSecurityTaxes - unionDues;

        transferFunds(netPay);
        this.yearToDateEarnings += periodPay;

        return netPay;
    }

    private double calculateUnionDues(double periodPay) {
        return myUnionDuesStrategy.calculateUnionDues(periodPay);
    }

    protected double calculateSocialSecurityTaxes(double periodPay) {
        return mySecurityTaxesStrategy.calculateSocialSecurityTaxes(periodPay, this.yearToDateEarnings);
    }

    protected double calculateStateTaxes(double periodPay) {
        return myStateTaxesStrategy.calculateStateTaxes(periodPay);
    }

    protected double calculateFederalTaxes(double annualPay, int payFrequency) {
        return myFederalTaxesStrategy.calculateFederalTaxes(annualPay, payFrequency);
    }

    protected abstract int getPayFrequency();

    protected abstract double getPeriodPay(double periodPay);

    protected void transferFunds(double netPay) {
        //code here that does the transferring
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public void setPayRate(double payRate) {
        this.payRate = payRate;
    }

    public String getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public double getPayRate() {
        return payRate;
    }

    public UnionDuesStrategy getMyUnionDuesStrategy() {
        return myUnionDuesStrategy;
    }

    public void setMyUnionDuesStrategy(UnionDuesStrategy myUnionDuesStrategy) {
        this.myUnionDuesStrategy = myUnionDuesStrategy;
    }
    public double getYearToDateEarnings() {
        return yearToDateEarnings;
    }
}
