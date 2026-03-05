public class EvaluationPipeline {
    private final IPlagChecker pc;
    private final ICodeGrader grader;
    private final IRepWriter writer;

    public EvaluationPipeline(IPlagChecker pc, ICodeGrader grader, IRepWriter writer) {
        this.pc = pc;
        this.grader = grader;
        this.writer = writer;
    }

    public void evaluate(Submission sub) {
        int plag = pc.check(sub);
        System.out.println("PlagiarismScore=" + plag);

        int code = grader.grade(sub);
        System.out.println("CodeScore=" + code);

        String reportName = writer.write(sub, plag, code);
        System.out.println("Report written: " + reportName);

        int total = plag + code;
        String result = (total >= 90) ? "PASS" : "FAIL";
        System.out.println("FINAL: " + result + " (total=" + total + ")");
    }
}
