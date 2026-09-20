import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static int subarraySum(int[] nums, int k) {
        // Map to store frequency of prefix sums: <PrefixSum, Frequency>
        Map<Integer, Integer> prefixCount = new HashMap<>();
        
        // Base case: a sum of 0 has occurred once before any elements are visited
        prefixCount.put(0, 1);
        
        int currentSum = 0;
        int totalSubarrays = 0;
        
        for (int num : nums) {
            currentSum += num;
            
            // Check if there is an earlier prefix sum such that: currentSum - earlierPrefix = k
            int targetPrefix = currentSum - k;
            if (prefixCount.containsKey(targetPrefix)) {
                totalSubarrays += prefixCount.get(targetPrefix);
            }
            
            // Record / increment the frequency of the current prefix sum
            prefixCount.put(currentSum, prefixCount.getOrDefault(currentSum, 0) + 1);
        }
        
        return totalSubarrays;
    }
}
