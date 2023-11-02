package strategy;

public class SocialSecurityTaxes implements SocialSecurityTaxesStrategy {

    @Override
    public double calculateSocialSecurityTaxes(double periodPay, double yearToDateEarnings) {
        double socialSecurityTaxes = 0;
        if(yearToDateEarnings < 168000) {
            socialSecurityTaxes = .15* periodPay;
        }
        return socialSecurityTaxes;
    }
}
