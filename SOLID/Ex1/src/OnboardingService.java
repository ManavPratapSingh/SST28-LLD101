import java.util.*;

public class OnboardingService {
    private final IDBRepository db;
    private final Utils utils;

    public OnboardingService(IDBRepository db, Utils utils) {
        this.db = db;
        this.utils = utils;
    }

    // Intentionally violates SRP: parses + validates + creates ID + saves + prints.
    public void registerFromRawInput(String raw) {
        System.out.println("INPUT: " + raw);

        var kv=utils.parseRawInput(raw);

        String name = kv.getOrDefault("name", "");
        String email = kv.getOrDefault("email", "");
        String phone = kv.getOrDefault("phone", "");
        String program = kv.getOrDefault("program", "");

        var isValid=utils.validateInput(name, email, phone, program);

        if (isValid) {
            String id = IdUtil.nextStudentId(db.count());
            StudentRecord rec = new StudentRecord(id, name, email, phone, program);

            db.save(rec);

            utils.logger(id, rec);
        }
    }
}
