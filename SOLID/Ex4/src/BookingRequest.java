import java.util.*;

public class BookingRequest {
    public final ILegacyRoom room;
    public final List<IAddOn> addOns;

    public BookingRequest(ILegacyRoom room, List<IAddOn> addOns) {
        this.room = room;
        this.addOns = addOns;
    }
}
