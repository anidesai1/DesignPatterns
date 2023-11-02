package strategy;

public class NoSocialSecurityTaxes implements SocialSecurityTaxesStrategy{
    @Override
    public double calculateSocialSecurityTaxes(double periodPay, double yearToDateEarnings) {
        return 0;
    }
}
