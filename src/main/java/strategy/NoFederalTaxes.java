package strategy;

public class NoFederalTaxes implements FederalTaxesStrategy{
    @Override
    public double calculateFederalTaxes(double annualPay, int payFrequency) {
        return 0;
    }
}
