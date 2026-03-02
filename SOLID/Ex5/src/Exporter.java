public abstract class Exporter {
    public final ExportResult export(ExportRequest req) {
        if (req == null || req.body == null) {
            return ExportResult.error("Invalid request");
        }
        if (!canExport(req)) {
            return ExportResult.error(getErrorMessage(req));
        }
        return doExport(req);
    }

    protected boolean canExport(ExportRequest req) {
        return true;
    }

    protected String getErrorMessage(ExportRequest req) {
        return "";
    }

    protected abstract ExportResult doExport(ExportRequest req);
}
