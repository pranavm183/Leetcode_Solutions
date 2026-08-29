import java.util.Arrays;

class Solution {
    public int maximumGap(int[] nums) {
        // Edge case: if array has less than 2 elements, gap is 0
        if (nums == null || nums.length < 2) {
            return 0;
        }

        int n = nums.length;
        int min = nums[0];
        int max = nums[0];

        // Step 1: Find the global minimum and maximum
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        // If all elements are identical, max gap is 0
        if (min == max) {
            return 0;
        }

        // Step 2: Calculate bucket size and count
        int bucketSize = (int) Math.ceil((double) (max - min) / (n - 1));
        int[] bucketMin = new int[n];
        int[] bucketMax = new int[n];
        
        Arrays.fill(bucketMin, Integer.MAX_VALUE);
        Arrays.fill(bucketMax, Integer.MIN_VALUE);

        // Step 3: Populate buckets with their min and max values
        for (int num : nums) {
            int bucketIdx = (num - min) / bucketSize;
            bucketMin[bucketIdx] = Math.min(bucketMin[bucketIdx], num);
            bucketMax[bucketIdx] = Math.max(bucketMax[bucketIdx], num);
        }

        // Step 4: Scan buckets to find the maximum gap
        int maxGap = 0;
        int previousMax = min; // Start tracking from the global minimum

        for (int i = 0; i < n; i++) {
            // Skip empty buckets
            if (bucketMin[i] == Integer.MAX_VALUE) {
                continue;
            }

            // Gap is measured from current bucket's min to previous bucket's max
            maxGap = Math.max(maxGap, bucketMin[i] - previousMax);
            previousMax = bucketMax[i];
        }

        return maxGap;
    }
}
