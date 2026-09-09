class NumArray {
    // Array to store cumulative prefix sums
    private int[] prefixSums;

    public NumArray(int[] nums) {
        // Create an array size N + 1 to easily handle the left boundary (0)
        prefixSums = new int[nums.length + 1];
        
        // Fill prefixSums array
        // prefixSums[i] will store the sum of nums[0] up to nums[i-1]
        for (int i = 0; i < nums.length; i++) {
            prefixSums[i + 1] = prefixSums[i] + nums[i];
        }
    }
    
    public int sumRange(int left, int right) {
        // The sum from index 'left' to 'right' inclusive is simply:
        // Total sum up to 'right' minus the total sum right before 'left'
        return prefixSums[right + 1] - prefixSums[left];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left, right);
 */
