class Solution {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";
        
        String result = "0";
        int trailingZeros = 0;
        
        // Loop through num2 from right to left
        for (int i = num2.length() - 1; i >= 0; i--) {
            int digit2 = num2.charAt(i) - '0';
            
            // Step 1: Multiply num1 by a single digit of num2
            String partialProduct = multiplyStringWithDigit(num1, digit2);
            
            // Step 2: Append trailing zeros based on position (e.g., *10, *100)
            StringBuilder sb = new StringBuilder(partialProduct);
            for (int z = 0; z < trailingZeros; z++) {
                sb.append("0");
            }
            
            // Step 3: Add this shifted partial product to our running total
            result = addStrings(result, sb.toString());
            trailingZeros++;
        }
        
        return result;
    }
    
    // Helper 1: Multiplies a large string number by a single digit (0-9)
    private String multiplyStringWithDigit(String num, int digit) {
        if (digit == 0) return "0";
        
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        
        for (int i = num.length() - 1; i >= 0; i--) {
            int currentDigit = num.charAt(i) - '0';
            int product = (currentDigit * digit) + carry;
            
            sb.append(product % 10);
            carry = product / 10;
        }
        
        if (carry > 0) {
            sb.append(carry);
        }
        
        return sb.reverse().toString();
    }
    
    // Helper 2: Adds two large string numbers together (LeetCode 415)
    private String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0;
        
        while (i >= 0 || j >= 0 || carry > 0) {
            int digit1 = (i >= 0) ? num1.charAt(i) - '0' : 0;
            int digit2 = (j >= 0) ? num2.charAt(j) - '0' : 0;
            
            int sum = digit1 + digit2 + carry;
            sb.append(sum % 10);
            carry = sum / 10;
            
            i--;
            j--;
        }
        
        return sb.reverse().toString();
    }
}
