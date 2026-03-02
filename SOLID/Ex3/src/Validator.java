import java.util.Optional;

public class Validator {
    public Optional<String> validateDisciplinaryFlag(StudentProfile s) {
        if (s.disciplinaryFlag != LegacyFlags.NONE) {
            return Optional.of("disciplinary flag present");
        }
        return Optional.empty();
    }

    public Optional<String> validateCGR(StudentProfile s) {
        if (s.cgr < 8.0) {
            return Optional.of("CGR below 8.0");
        }
        return Optional.empty();
    }

    public Optional<String> validateAttendance(StudentProfile s) {
        if (s.attendancePct < 75) {
            return Optional.of("attendance below 75");
        }
        return Optional.empty();
    }

    public Optional<String> validateCredits(StudentProfile s) {
        if (s.earnedCredits < 20) {
            return Optional.of("credits below 20");
        }
        return Optional.empty();
    }
}
