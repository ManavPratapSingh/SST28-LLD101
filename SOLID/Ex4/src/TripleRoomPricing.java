public class TripleRoomPricing implements RoomPricing {
    @Override
    public boolean matches(int type) {
        return type == LegacyRoomTypes.TRIPLE;
    }

    @Override
    public Money getBasePrice() {
        return new Money(12000.0);
    }
}
