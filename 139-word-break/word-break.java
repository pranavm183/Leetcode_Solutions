import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        // Convert the list to a HashSet for O(1) lookups
        Set<String> wordSet = new HashSet<>(wordDict);
        
        // dp[i] will store true if s[0...i-1] can be segmented
        boolean[] dp = new boolean[s.length() + 1];
        
        // Base case: empty string is valid
        dp[0] = true;
        
        // Iterate through all lengths of the substring
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                // If s[0...j-1] is valid and s[j...i-1] is in the dictionary
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break; // Move to the next index 'i' since we found a valid split
                }
            }
        }
        
        // Return true if the full string can be segmented
        return dp[s.length()];
    }
}
