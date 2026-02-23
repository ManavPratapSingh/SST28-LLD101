import java.util.*;

public class HostelFeeCalculator {
    private final FakeBookingRepo repo;
    private final List<RoomPricing> roomRules;
    private final List<AddOnPricing> addOnRules;

    public HostelFeeCalculator(FakeBookingRepo repo,
            List<RoomPricing> roomRules,
            List<AddOnPricing> addOnRules) {
        this.repo = repo;
        this.roomRules = roomRules;
        this.addOnRules = addOnRules;
    }

    public void process(BookingRequest req) {
        Money monthly = calculateMonthly(req);
        Money deposit = new Money(5000.00);

        ReceiptPrinter.print(req, monthly, deposit);

        String bookingId = "H-" + (7000 + new Random(1).nextInt(1000));
        repo.save(bookingId, req, monthly, deposit);
    }

    private Money calculateMonthly(BookingRequest req) {
        Money base = new Money(0.0);
        for (RoomPricing rule : roomRules) {
            if (rule.matches(req.roomType)) {
                base = rule.getBasePrice();
                break;
            }
        }

        Money add = new Money(0.0);
        for (AddOn a : req.addOns) {
            for (AddOnPricing rule : addOnRules) {
                if (rule.matches(a)) {
                    add = add.plus(rule.getPrice());
                    break;
                }
            }
        }

        return base.plus(add);
    }
}
