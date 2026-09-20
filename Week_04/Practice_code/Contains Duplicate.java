public class Solution {
    public static boolean containsDuplicate(int[] nums) {
        // Compare every element with every subsequent element
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return true; // Duplicate found immediately
                }
            }
        }
        return false; // All elements are unique
    }
}
