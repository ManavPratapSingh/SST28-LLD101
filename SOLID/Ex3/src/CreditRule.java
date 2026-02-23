import java.util.Optional;

public class CreditRule implements EligibilityRule {
    @Override
    public Optional<String> check(StudentProfile s) {
        if (s.earnedCredits < 20) {
            return Optional.of("credits below 20");
        }
        return Optional.empty();
    }
}
