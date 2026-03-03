public class WhatsAppSender extends NotificationSender {
    public WhatsAppSender(AuditLog audit) { super(audit); }

    @Override
    protected boolean canSend(Notification n) {
        if (!n.phone.startsWith("+")) throw new IllegalArgumentException("phone must start with + and country code");
        return n.phone.startsWith("+");
    }

    @Override
    public void doSend(Notification n) {
        System.out.println("WA -> to=" + n.phone + " body=" + n.body);
        audit.add("wa sent");
    }
}
