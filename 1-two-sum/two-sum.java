class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        int temp = 0;
        
        for (int i = 0; i < n; i++) {
            temp = target - nums[i];
            
            for (int j = i + 1; j < n; j++) {
                if (nums[j] == temp) {
                    return new int[] { i, j };
                }
            }
        }
        
        return new int[] {};
    }
}
