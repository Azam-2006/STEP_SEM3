import java.util.*;

public class WordFrequencyReport {

    public static void printFilteredWordFrequency(String feedback) {
        // Set of stop words for fast lookup
        Set<String> stopWords = new HashSet<>(Arrays.asList("the", "was", "and", "a", "is", "of", "in"));

        // Normalize string: convert to lowercase and clear common punctuation
        String cleaned = feedback.toLowerCase()
                                 .replace(".", "")
                                 .replace(",", "")
                                 .replace("!", "")
                                 .replace("?", "");

        // Split on whitespace sequence
        String[] words = cleaned.split("\\s+");

        // Frequency table
        Map<String, Integer> freqMap = new HashMap<>();

        for (String word : words) {
            if (word.isEmpty() || stopWords.contains(word)) {
                continue;
            }
            freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);
        }

        // Convert map entries to list and sort descending by frequency
        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(freqMap.entrySet());
        entryList.sort((e1, e2) -> e2.getValue().compareTo(e1.getValue()));

        // Print frequency report
        for (Map.Entry<String, Integer> entry : entryList) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        printFilteredWordFrequency("The mentor was great, the session was great and clear.");
    }
}
