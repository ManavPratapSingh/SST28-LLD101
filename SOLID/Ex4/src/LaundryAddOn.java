public class LaundryAddOn implements IAddOn{
    @Override
    public double getPrice() {
        return 500.0;
    }

    @Override
    public String getName() {
        return "LAUNDRY";
    }
}
