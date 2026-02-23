public class InvoiceFormatter {

    public String formatLineDetail(String name, int qty, double lineTotal) {
        return String.format("- %s x%d = %.2f\n", name, qty, lineTotal);
    }

    public String formatInvoice(String invId, String lineDetails,
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
}
