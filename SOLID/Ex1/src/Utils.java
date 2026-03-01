import java.util.LinkedHashMap;

public class Utils {
    public LinkedHashMap<String, String> parseRawInput(String raw) {
        LinkedHashMap<String,String> kv = new LinkedHashMap<>();
        String[] parts = raw.split(";");
        for (String p : parts) {
            String[] t = p.split("=", 2);
            if (t.length == 2) kv.put(t[0].trim(), t[1].trim());
        }
        return kv;
    }

    public void logger(String id, StudentRecord rec) {
        System.out.println("OK: created student " + id);
        System.out.println("CONFIRMATION:");
        rec.toString();
    }

    public boolean validateInput(String name, String email, String phone, String program) {
        boolean isValid = true;
        if (name.isBlank()) {
            System.out.println("ERROR: name is required");
            isValid = false;
        }
        if (email.isBlank() || !email.contains("@")) {
            System.out.println("ERROR: email is invalid");
            isValid = false;
        }
        if (phone.isBlank() || !phone.chars().allMatch(Character::isDigit)) {
            System.out.println("ERROR: phone is invalid");
            isValid = false;
        }
        if (!(program.equals("CSE") || program.equals("AI") || program.equals("SWE"))) {
            System.out.println("ERROR: program is invalid");
            isValid = false;
        }
        return isValid;
    }
}
