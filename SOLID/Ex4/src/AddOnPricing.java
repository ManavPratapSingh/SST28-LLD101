public interface AddOnPricing {
    boolean matches(AddOn addOn);

    Money getPrice();
}
