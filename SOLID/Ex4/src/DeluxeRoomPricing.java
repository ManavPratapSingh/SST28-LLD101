public class DeluxeRoomPricing implements RoomPricing {
    @Override
    public boolean matches(int type) {
        return true;
    } // Default/Catch-all for Legacy logic

    @Override
    public Money getBasePrice() {
        return new Money(16000.0);
    }
}
