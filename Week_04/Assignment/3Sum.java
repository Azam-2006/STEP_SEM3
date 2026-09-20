import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static int[][] threeSum(int[] nums) {
        Arrays.sort(nums);
        List<int[]> resultList = new ArrayList<>();
        int n = nums.length;

        for (int i = 0; i < n - 2; i++) {
            // If the smallest value is > 0, the sum cannot be 0
            if (nums[i] > 0) {
                break;
            }

            // Skip duplicate values for the first element
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    resultList.add(new int[]{nums[i], nums[left], nums[right]});

                    // Skip duplicate elements for left pointer
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    // Skip duplicate elements for right pointer
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }

                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return resultList.toArray(new int[resultList.size()][]);
    }
}
