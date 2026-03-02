public class TripleLegacyRoom implements ILegacyRoom{

    @Override
    public double getBasePrice() {
        return 12000.0;
    }

    @Override
    public String getType() { return "TRIPLE"; }
}
