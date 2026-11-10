class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] charMap = new int[128]; // Defaults to all 0s
        int left = 0;
        int maxLength = 0;
        
        for (int right = 0; right < s.length(); right++) {
            char currChar = s.charAt(right);
            
            // Directly jump left to the stored position if it's further ahead
            left = Math.max(left, charMap[currChar]);
            
            // Store right + 1 so it's always greater than 0
            charMap[currChar] = right + 1;
            maxLength = Math.max(maxLength, right - left + 1);
        }
        
        return maxLength;
    }
}