class Solution {
    public String removeKdigits(String num, int k) {
        // Edge case: If we need to remove all digits or more, return "0"
        if (num.length() <= k) {
            return "0";
        }
        
        // Use StringBuilder as a monotonic stack
        StringBuilder stack = new StringBuilder();
        
        for (int i = 0; i < num.length(); i++) {
            char digit = num.charAt(i);
            
            // Greedily pop elements from the stack if they are larger than the current digit
            while (k > 0 && stack.length() > 0 && stack.charAt(stack.length() - 1) > digit) {
                stack.deleteCharAt(stack.length() - 1);
                k--;
            }
            stack.append(digit);
        }
        
        // Edge Case 1: If k > 0 after processing all digits (e.g., "1111" or "1234")
        // The remaining digits are sorted. Slice off the largest characters from the end.
        while (k > 0) {
            stack.deleteCharAt(stack.length() - 1);
            k--;
        }
        
        // Edge Case 2: Strip leading zeros
        int nonZeroIdx = 0;
        while (nonZeroIdx < stack.length() && stack.charAt(nonZeroIdx) == '0') {
            nonZeroIdx++;
        }
        
        // Extract the substring starting from the first non-zero index
        String result = stack.substring(nonZeroIdx);
        
        // Edge Case 3: If everything was stripped, return "0"
        return result.isEmpty() ? "0" : result;
    }
}
