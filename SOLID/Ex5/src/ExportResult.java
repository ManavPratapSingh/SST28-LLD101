public class ExportResult {
    public final String contentType;
    public final byte[] bytes;

    public ExportResult(String contentType, byte[] bytes) {
        this.contentType = contentType;
        this.bytes = bytes;
    }

    public static ExportResult error(String message) {
        throw new RuntimeException(message);
    }
}
