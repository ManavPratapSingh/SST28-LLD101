public class GymAddOn implements IAddOn{
    @Override
    public double getPrice() {
        return 300.0;
    }

    @Override
    public String getName() {
        return "GYM";
    }
}
