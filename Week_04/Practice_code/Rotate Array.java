public class Solution {
    public static int[] rotateArray(int[] nums, int k) {
        int n = nums.length;
        if (n == 0) {
            return nums;
        }

        // Normalize k to prevent redundant complete cycles
        k = k % n;

        int[] rotated = new int[n];

        // Place each element at its new wrapped position
        for (int i = 0; i < n; i++) {
            int newIndex = (i + k) % n;
            rotated[newIndex] = nums[i];
        }

        // Optional: Copy back into the original array
        for (int i = 0; i < n; i++) {
            nums[i] = rotated[i];
        }

        return rotated;
    }
}
