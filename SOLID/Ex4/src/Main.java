import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Hostel Fee Calculator ===");

        List<RoomPricing> roomRules = List.of(
                new SingleRoomPricing(),
                new DoubleRoomPricing(),
                new TripleRoomPricing(),
                new DeluxeRoomPricing() // Catch-all
        );

        List<AddOnPricing> addOnRules = List.of(
                new MessPricing(),
                new LaundryPricing(),
                new GymPricing());

        BookingRequest req = new BookingRequest(LegacyRoomTypes.DOUBLE, List.of(AddOn.LAUNDRY, AddOn.MESS));
        HostelFeeCalculator calc = new HostelFeeCalculator(new FakeBookingRepo(), roomRules, addOnRules);
        calc.process(req);
    }
}
