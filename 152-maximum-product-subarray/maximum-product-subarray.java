class Solution {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int maxProd = nums[0];
        int minProd = nums[0];
        int ans = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            int curr = nums[i];
            int tempMax = maxProd * curr;
            int tempMin = minProd * curr;
            
            maxProd = Math.max(curr, Math.max(tempMax, tempMin));
            minProd = Math.min(curr, Math.min(tempMax, tempMin));
            
            ans = Math.max(ans, maxProd);
        }
        
        return ans;
    }
}