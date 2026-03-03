public abstract class NotificationSender {
    protected final AuditLog audit;
    protected NotificationSender(AuditLog audit) { this.audit = audit; }

    protected boolean canSend (Notification notification) { return true; }
    protected abstract void doSend (Notification notification);
    public void send(Notification n)
    throws Exception{
        if (n==null || (n.email==null && n.phone==null)) {
            throw new IllegalArgumentException("email or phone must be provided");
        }
        if (canSend(n)) {
            doSend(n);
        }
    };
}
