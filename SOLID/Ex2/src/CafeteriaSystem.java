import java.util.*;

public class CafeteriaSystem {
    private final Map<String, MenuItem> menu = new LinkedHashMap<>();
    private final FileStore store = new FileStore();
    private int invoiceSeq = 1000;

    public void addToMenu(MenuItem i) {
        menu.put(i.id, i);
    }

    private double computeSubtotal(List<OrderLine> lines, StringBuilder lineDetails) {
        double subtotal = 0.0;
        for (OrderLine l : lines) {
            MenuItem item = menu.get(l.itemId);
            double lineTotal = item.price * l.qty;
            subtotal += lineTotal;
            lineDetails.append(String.format("- %s x%d = %.2f\n", item.name, l.qty, lineTotal));
        }
        return subtotal;
    }

    private double computeTax(String customerType, double subtotal) {
        double taxPct = TaxRules.taxPercent(customerType);
        return subtotal * (taxPct / 100.0);
    }

    private double computeDiscount(String customerType, double subtotal, int distinctLines) {
        return DiscountRules.discountAmount(customerType, subtotal, distinctLines);
    }

    private String formatInvoice(String invId, StringBuilder lineDetails,
            double subtotal, double taxPct, double tax,
            double discount, double total) {
        StringBuilder out = new StringBuilder();
        out.append("Invoice# ").append(invId).append("\n");
        out.append(lineDetails);
        out.append(String.format("Subtotal: %.2f\n", subtotal));
        out.append(String.format("Tax(%.0f%%): %.2f\n", taxPct, tax));
        out.append(String.format("Discount: -%.2f\n", discount));
        out.append(String.format("TOTAL: %.2f\n", total));
        return out.toString();
    }

    private void saveInvoice(String invId, String printable) {
        store.save(invId, printable);
        System.out.println("Saved invoice: " + invId + " (lines=" + store.countLines(invId) + ")");
    }

    public void checkout(String customerType, List<OrderLine> lines) {
        String invId = "INV-" + (++invoiceSeq);

        StringBuilder lineDetails = new StringBuilder();
        double subtotal = computeSubtotal(lines, lineDetails);

        double taxPct = TaxRules.taxPercent(customerType);
        double tax = computeTax(customerType, subtotal);

        double discount = computeDiscount(customerType, subtotal, lines.size());

        double total = subtotal + tax - discount;

        String printable = formatInvoice(invId, lineDetails, subtotal, taxPct, tax, discount, total);
        System.out.print(printable);

        saveInvoice(invId, printable);
    }
}
