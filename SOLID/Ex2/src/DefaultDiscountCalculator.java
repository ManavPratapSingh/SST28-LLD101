public class DefaultDiscountCalculator implements DiscountCalculator {
    @Override
    public double discountAmount(double subtotal, int distinctItems) {
        return 0.0;
    }
}
