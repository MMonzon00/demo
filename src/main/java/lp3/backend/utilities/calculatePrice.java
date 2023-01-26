package lp3.backend.utilities;


public class calculatePrice {
    public Float calculatePrice(Float price, Float percentage) {
        Float priceTaxed = price * (1 + percentage);
        return priceTaxed;
    }
}