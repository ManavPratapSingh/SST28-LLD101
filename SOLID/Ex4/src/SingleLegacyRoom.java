public class SingleLegacyRoom implements ILegacyRoom{

    @Override
    public double getBasePrice() {
        return 14000.0;
    }

    @Override
    public String getType() { return "SINGLE"; }
}
