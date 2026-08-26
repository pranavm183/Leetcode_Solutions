class Solution {
    public boolean canJump(int[] nums) {
        // Tracks the maximum index we can reach so far
        int maxReach = 0;
        
        for (int i = 0; i < nums.length; i++) {
            // If the current index is greater than the maximum reachable index,
            // it means we are stuck and cannot proceed further.
            if (i > maxReach) {
                return false;
            }
            
            // Update the maximum reachable index from the current position
            maxReach = Math.max(maxReach, i + nums[i]);
            
            // Optimization: If we can already reach or exceed the last index, return true
            if (maxReach >= nums.length - 1) {
                return true;
            }
        }
        
        return true;
    }
}
