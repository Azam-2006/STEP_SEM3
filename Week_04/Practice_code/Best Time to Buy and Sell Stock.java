public class Solution {
    public static int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }

        int minPriceSoFar = prices[0];
        int maxProfitSoFar = 0;

        // Traverse through the prices day by day
        for (int i = 1; i < prices.length; i++) {
            // Update the minimum buy price if a lower price is found
            if (prices[i] < minPriceSoFar) {
                minPriceSoFar = prices[i];
            } else {
                // Calculate profit if sold today and compare with current best
                int profitToday = prices[i] - minPriceSoFar;
                if (profitToday > maxProfitSoFar) {
                    maxProfitSoFar = profitToday;
                }
            }
        }

        return maxProfitSoFar;
    }
}
