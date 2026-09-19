public class PalindromeChecker {

    // Approach 1: Iterative two-pointer comparison
    public static boolean isPalindromeIterative(String text) {
        int left = 0;
        int right = text.length() - 1;

        while (left < right) {
            if (text.charAt(left) != text.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // Approach 2: Recursive check shrinking inward
    public static boolean isPalindromeRecursive(String text) {
        if (text.length() <= 1) {
            return true;
        }
        if (text.charAt(0) != text.charAt(text.length() - 1)) {
            return false;
        }
        return isPalindromeRecursive(text.substring(1, text.length() - 1));
    }

    // Approach 3: Array reversal comparison
    public static boolean isPalindromeArrayReversal(String text) {
        char[] original = text.toCharArray();
        char[] reversed = new char[original.length];

        for (int i = 0; i < original.length; i++) {
            reversed[i] = original[original.length - 1 - i];
        }

        for (int i = 0; i < original.length; i++) {
            if (original[i] != reversed[i]) {
                return false;
            }
        }
        return true;
    }

    private static String formatResult(boolean result) {
        return result ? "Palindrome" : "Not Palindrome";
    }

    public static void main(String[] args) {
        String[] testCases = {"madam", "hello", "racecar", "step", "noon"};

        System.out.println("=== QA Palindrome Verification Toolkit ===");
        for (String test : testCases) {
            String cleanText = test.toLowerCase().replaceAll("[^a-zA-Z0-9]", "");

            boolean iter = isPalindromeIterative(cleanText);
            boolean recur = isPalindromeRecursive(cleanText);
            boolean arrRev = isPalindromeArrayReversal(cleanText);

            System.out.printf("\"%s\" -> Iterative: %s | Recursive: %s | Array Reversal: %s%n",
                    test, formatResult(iter), formatResult(recur), formatResult(arrRev));
        }
    }
}
