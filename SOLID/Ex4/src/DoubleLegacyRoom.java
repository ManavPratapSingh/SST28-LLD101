public class DoubleLegacyRoom implements ILegacyRoom{

    @Override
    public double getBasePrice() {
        return 15000.0;
    }

    @Override
    public String getType() { return "DOUBLE"; }
}
