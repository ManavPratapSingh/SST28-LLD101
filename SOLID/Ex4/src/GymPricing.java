public class GymPricing implements AddOnPricing {
    @Override
    public boolean matches(AddOn a) {
        return a == AddOn.GYM;
    }

    @Override
    public Money getPrice() {
        return new Money(300.0);
    }
}
