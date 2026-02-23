public class MessPricing implements AddOnPricing {
    @Override
    public boolean matches(AddOn a) {
        return a == AddOn.MESS;
    }

    @Override
    public Money getPrice() {
        return new Money(1000.0);
    }
}
