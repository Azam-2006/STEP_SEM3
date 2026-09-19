public class MaskedPhoneNumberFormatter {

    public static String maskPhoneNumber(String phone) {
        if (phone == null || phone.length() != 10) {
            return "Invalid phone number";
        }

        // Verify all 10 characters are numeric digits
        for (int i = 0; i < phone.length(); i++) {
            if (!Character.isDigit(phone.charAt(i))) {
                return "Invalid phone number";
            }
        }

        // Build masked string using StringBuilder
        StringBuilder sb = new StringBuilder();
        sb.append("XXXXXX");
        sb.append(phone.substring(6)); // Last 4 digits (indices 6 to 9)
        sb.insert(6, "-");            // Insert separator between mask and digits

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(maskPhoneNumber("9876543210")); // Output: XXXXXX-3210
        System.out.println(maskPhoneNumber("98765"));      // Output: Invalid phone number
    }
}
