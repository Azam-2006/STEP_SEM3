public class IsbnValidator {

    public static String normalizeCode(String raw) {
        if (raw == null) return "";
        
        String trimmed = raw.trim();
        if (trimmed.length() < 3) {
            return trimmed.toUpperCase();
        }

        // Uppercase only the first 3 characters, keep the rest untouched
        String pubCode = trimmed.substring(0, 3).toUpperCase();
        String remaining = trimmed.substring(3);

        return pubCode + remaining;
    }

    public static String validateAndFormat(String code) {
        // Step 1: Check total length
        if (code.length() != 13) {
            return "Invalid: code must be exactly 13 characters";
        }

        // Step 2: Validate first 3 characters (Publisher Code) are letters
        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(code.charAt(i))) {
                return "Invalid: publisher code must be 3 letters";
            }
        }

        // Step 3: Validate remaining 10 characters are digits
        for (int i = 3; i < 13; i++) {
            if (!Character.isDigit(code.charAt(i))) {
                return "Invalid: body must contain only digits";
            }
        }

        // Step 4: Extract parts and format output
        String pubCode = code.substring(0, 3);
        String year = code.substring(3, 7);
        String catalog = code.substring(7, 13);

        StringBuilder sb = new StringBuilder();
        sb.append("[").append(pubCode).append("] ")
          .append("YEAR: ").append(year).append(" | ")
          .append("CATALOG: ").append(catalog);

        return sb.toString();
    }

    public static void main(String[] args) {
        String code1 = normalizeCode(" pen2026004251 ");
        System.out.println(validateAndFormat(code1));

        String code2 = normalizeCode("12N2026004251");
        System.out.println(validateAndFormat(code2));
    }
}
