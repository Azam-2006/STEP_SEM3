import java.util.LinkedHashMap;
import java.util.Map;

public class FirstUniqueCharacter {

    public static char findFirstNonRepeatingChar(String text) {
        if (text == null || text.isEmpty()) {
            return '\0';
        }

        // Frequency map maintaining insertion order
        Map<Character, Integer> freqMap = new LinkedHashMap<>();

        for (char c : text.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        // Left-to-right scan
        for (char c : text.toCharArray()) {
            if (freqMap.get(c) == 1) {
                return c;
            }
        }

        return '\0'; // Sentinel character indicating no unique letter
    }

    public static void main(String[] args) {
        String[] samples = {"swiss", "aabbcc", "stress", "relevel", "bridge"};

        System.out.println("=== Unique Letter Hunt Mini-Game ===");
        for (String sample : samples) {
            char result = findFirstNonRepeatingChar(sample);
            if (result != '\0') {
                System.out.printf("\"%s\" -> First Non-Repeating Character: '%c'%n", sample, result);
            } else {
                System.out.printf("\"%s\" -> No Non-Repeating Character Found%n", sample);
            }
        }
    }
}
