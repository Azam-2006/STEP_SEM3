public class Solution {
    public static int[] mergeSortedArrays(int[] arr1, int[] arr2) {
        int[] result = new int[arr1.length + arr2.length];
        int p1 = 0; // Pointer for arr1
        int p2 = 0; // Pointer for arr2
        int k = 0;  // Pointer for result array

        // Compare and merge smaller elements until one array is exhausted
        while (p1 < arr1.length && p2 < arr2.length) {
            if (arr1[p1] <= arr2[p2]) {
                result[k] = arr1[p1];
                p1++;
            } else {
                result[k] = arr2[p2];
                p2++;
            }
            k++;
        }

        // Copy remaining elements from arr1, if any
        while (p1 < arr1.length) {
            result[k] = arr1[p1];
            p1++;
            k++;
        }

        // Copy remaining elements from arr2, if any
        while (p2 < arr2.length) {
            result[k] = arr2[p2];
            p2++;
            k++;
        }

        return result;
    }
}
