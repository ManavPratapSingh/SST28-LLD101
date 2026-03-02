import java.util.*;
import java.util.stream.Collectors;

public class ReceiptPrinter {
    public static void print(BookingRequest req, Money monthly, Money deposit) {
        List<String> addOnNames=req.addOns.stream()
                .map(IAddOn::getName)
                .toList();
        System.out.println("Room: " + req.room.getType() + " | AddOns: " + addOnNames);
        System.out.println("Monthly: " + monthly);
        System.out.println("Deposit: " + deposit);
        System.out.println("TOTAL DUE NOW: " + monthly.plus(deposit));
    }
}
