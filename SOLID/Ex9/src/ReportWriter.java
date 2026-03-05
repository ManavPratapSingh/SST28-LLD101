public class ReportWriter implements IRepWriter {
    public String write(Submission s, int plag, int code) {
        // writes to a pretend file name
        return "report-" + s.roll + ".txt";
    }
}
