package strategy;

import templatemethodpattern.Address;

public class StateTaxes implements StateTaxesStrategy {
    Address address;
    @Override
    public double calculateStateTaxes(double periodPay) {
        double stateTaxes = 0;
        switch (address.getState()) {
            case "AL" -> {
                stateTaxes = .02 * periodPay;
            }

            case "CA" -> {
                stateTaxes = .10 * periodPay;
            }

            case "FL" -> {
                stateTaxes = .03 * periodPay;
            }
            default -> {
                stateTaxes = .05 * periodPay;
            }
        }
        return stateTaxes;
    }
}
