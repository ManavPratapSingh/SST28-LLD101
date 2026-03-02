public class DeluxeLegacyRoom implements ILegacyRoom{

    @Override
    public double getBasePrice() {
        return 16000.0;
    }

    @Override
    public String getType() { return "DELUXE"; }
}
