public class DoubleRoomPricing implements RoomPricing {
    @Override
    public boolean matches(int type) {
        return type == LegacyRoomTypes.DOUBLE;
    }

    @Override
    public Money getBasePrice() {
        return new Money(15000.0);
    }
}
