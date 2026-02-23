public class LaundryPricing implements AddOnPricing {
    @Override
    public boolean matches(AddOn a) {
        return a == AddOn.LAUNDRY;
    }

    @Override
    public Money getPrice() {
        return new Money(500.0);
    }
}
