public class BankTransactionValidator {

    public static String normalizeReference(String raw) {
        if (raw == null) {
            return "";
        }

        String trimmed = raw.trim();

        // If string is shorter than 3 chars, uppercase the entire string
        if (trimmed.length() < 3) {
            return trimmed.toUpperCase();
        }

        // Uppercase only the first 3 characters and leave the rest as-is
        return trimmed.substring(0, 3).toUpperCase() + trimmed.substring(3);
    }

    public static String validateAndFormat(String reference) {
        if (reference == null || reference.length() != 14) {
            return "Invalid: wrong length (must be 14 characters)";
        }

        // First 3 characters must be letters
        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(reference.charAt(i))) {
                return "Invalid: bank code must be 3 letters";
            }
        }

        // Next 11 characters (indices 3 through 13) must be digits
        for (int i = 3; i < 14; i++) {
            if (!Character.isDigit(reference.charAt(i))) {
                return "Invalid: non-digit body in date/sequence";
            }
        }

        // Deconstruct components
        String bankCode = reference.substring(0, 3);
        String day = reference.substring(3, 5);
        String month = reference.substring(5, 7);
        String year = reference.substring(7, 9);
        String seq = reference.substring(9, 14);

        // Build formatted display line using StringBuilder
        StringBuilder sb = new StringBuilder();
        sb.append("[").append(bankCode).append("] ");
        sb.append("DATE: ").append(day).append("/").append(month).append("/").append(year);
        sb.append(" | SEQ: ").append(seq);

        return sb.toString();
    }

    public static void main(String[] args) {
        String input1 = "   hdf03022600042   ";
        String normalized1 = normalizeReference(input1);
        System.out.println(validateAndFormat(normalized1));
        // Output: [HDF] DATE: 03/02/26 | SEQ: 00042

        String input2 = "12F03022600042";
        String normalized2 = normalizeReference(input2);
        System.out.println(validateAndFormat(normalized2));
        // Output: Invalid: bank code must be 3 letters
    }
}
