import java.util.*;

public class CafeteriaSystem {
    private final Map<String, MenuItem> menu = new LinkedHashMap<>();
    private final TaxCalculator taxCalculator;
    private final DiscountCalculator discountCalculator;
    private final InvoiceFormatter formatter;
    private final InvoiceStore store;
    private int invoiceSeq = 1000;

    public CafeteriaSystem(TaxCalculator taxCalculator,
            DiscountCalculator discountCalculator,
            InvoiceFormatter formatter,
            InvoiceStore store) {
        this.taxCalculator = taxCalculator;
        this.discountCalculator = discountCalculator;
        this.formatter = formatter;
        this.store = store;
    }

    public void addToMenu(MenuItem i) {
        menu.put(i.id, i);
    }

    public void checkout(List<OrderLine> lines) {
        String invId = "INV-" + (++invoiceSeq);

        StringBuilder lineDetails = new StringBuilder();
        double subtotal = 0.0;
        for (OrderLine l : lines) {
            MenuItem item = menu.get(l.itemId);
            double lineTotal = item.price * l.qty;
            subtotal += lineTotal;
            lineDetails.append(formatter.formatLineDetail(item.name, l.qty, lineTotal));
        }

        double taxPct = taxCalculator.taxPercent();
        double tax = subtotal * (taxPct / 100.0);

        double discount = discountCalculator.discountAmount(subtotal, lines.size());

        double total = subtotal + tax - discount;

        String printable = formatter.formatInvoice(invId, lineDetails.toString(),
                subtotal, taxPct, tax, discount, total);
        System.out.print(printable);

        store.save(invId, printable);
        System.out.println("Saved invoice: " + invId + " (lines=" + store.countLines(invId) + ")");
    }
}
