package strategy;

public class NoStateTaxes implements StateTaxesStrategy{
    @Override
    public double calculateStateTaxes(double periodPay) {
        return 0;
    }
}
