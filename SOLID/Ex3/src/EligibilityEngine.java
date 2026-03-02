import java.util.*;

public class EligibilityEngine {
    private final IDBRepository repository;
    private final Validator validator;

    public EligibilityEngine(IDBRepository repository, Validator validator) {
        this.repository = repository;
        this.validator = validator;
    }

    public void runAndPrint(StudentProfile s) {
        ReportPrinter p = new ReportPrinter();
        EligibilityEngineResult r = evaluate(s); // giant conditional inside
        p.print(s, r);
        repository.save(s.rollNo, r.status);
    }

    public EligibilityEngineResult evaluate(StudentProfile s) {
        List<String> reasons = new ArrayList<>();
        String status = "ELIGIBLE";

        var disciplinaryFlagValidation = validator.validateDisciplinaryFlag(s);
        if (disciplinaryFlagValidation.isPresent()) {
            status = "INELIGIBLE";
            reasons.add(disciplinaryFlagValidation.get());
        }

        var cgrValidation = validator.validateCGR(s);
        if (cgrValidation.isPresent()) {
            status = "INELIGIBLE";
            reasons.add(cgrValidation.get());
        }

        var attendanceValidation = validator.validateAttendance(s);
        if (attendanceValidation.isPresent()) {
            status = "INELIGIBLE";
            reasons.add(attendanceValidation.get());
        }

        var creditsValidation = validator.validateCredits(s);
        if (creditsValidation.isPresent()) {
            status = "INELIGIBLE";
            reasons.add(creditsValidation.get());
        }

        return new EligibilityEngineResult(status, reasons);
    }
}

class EligibilityEngineResult {
    public final String status;
    public final List<String> reasons;
    public EligibilityEngineResult(String status, List<String> reasons) {
        this.status = status;
        this.reasons = reasons;
    }
}
