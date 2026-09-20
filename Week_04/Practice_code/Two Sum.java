public class Solution {
    public static int[] twoSum(int[] nums, int target) {
        // Iterate through each element as the first number of the pair
        for (int i = 0; i < nums.length; i++) {
            // Check all subsequent elements to avoid pairing an element with itself
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{}; // Fallback if no pair matches
    }
}
