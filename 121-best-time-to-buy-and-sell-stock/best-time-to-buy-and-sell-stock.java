class Solution {
    public int maxProfit(int[] prices) {
        // Handle edge case where no transaction can be made
        if (prices == null || prices.length < 2) {
            return 0;
        }
        
        int minPrice = prices[0]; // Track the lowest buying price
        int maxProfit = 0;        // Track the maximum profit found
        
        // Iterate through the prices starting from the second day
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                // Found a cheaper day to buy
                minPrice = prices[i];
            } else {
                // Calculate potential profit if sold today
                int currentProfit = prices[i] - minPrice;
                // Update maxProfit if this current profit is higher
                maxProfit = Math.max(maxProfit, currentProfit);
            }
        }
        
        return maxProfit;
    }
}
