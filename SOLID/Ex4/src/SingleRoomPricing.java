public class SingleRoomPricing implements RoomPricing {
    @Override
    public boolean matches(int type) {
        return type == LegacyRoomTypes.SINGLE;
    }

    @Override
    public Money getBasePrice() {
        return new Money(14000.0);
    }
}
