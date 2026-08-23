public class Solution {
    public int numTrees(int n) {
        // dp[i] stores the number of unique BSTs that can be formed with i structural nodes
        int[] dp = new int[n + 1];
        
        // Base cases
        dp[0] = 1; // An empty tree is 1 unique structural arrangement
        dp[1] = 1; // A single-node tree is 1 unique arrangement
        
        // Fill the DP table iteratively
        for (int i = 2; i <= n; i++) {
            // Pick each node 'j' as the root of the current subtree of size 'i'
            for (int j = 1; j <= i; j++) {
                // Left subtree elements count: j - 1
                // Right subtree elements count: i - j
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        
        return dp[n];
    }
}
