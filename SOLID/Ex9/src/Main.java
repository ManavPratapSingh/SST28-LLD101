public class Main {
    public static void main(String[] args) {
        System.out.println("=== Evaluation Pipeline ===");
        Submission sub = new Submission("23BCS1007", "public class A{}", "A.java");

        Rubric rubric = new Rubric();
        IPlagChecker pc = new PlagiarismChecker();
        ICodeGrader grader = new CodeGrader(rubric);
        IRepWriter writer = new ReportWriter();

        EvaluationPipeline pipeline = new EvaluationPipeline(pc, grader, writer);
        pipeline.evaluate(sub);
    }
}
