import java.util.HashMap;
import java.util.Map;

class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        // Base case: if numerator is 0, the fraction is simply "0"
        if (numerator == 0) {
            return "0";
        }
        
        StringBuilder result = new StringBuilder();
        
        // Determine the sign of the result
        // XOR returns true if exactly one of the operands is true (one negative, one positive)
        if (numerator < 0 ^ denominator < 0) {
            result.append("-");
        }
        
        // Convert to absolute long values to prevent integer overflow
        // e.g., Math.abs(Integer.MIN_VALUE) overflows standard 32-bit int
        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);
        
        // Calculate and append the integer part
        result.append(num / den);
        
        // Calculate the initial remainder
        long remainder = num % den;
        
        // If it divides perfectly, return the integer string
        if (remainder == 0) {
            return result.toString();
        }
        
        // Append the decimal point
        result.append(".");
        
        // Map to store (remainder -> index in StringBuilder where this remainder occurred)
        Map<Long, Integer> seenRemainders = new HashMap<>();
        
        // Simulate long division for the fractional part
        while (remainder != 0) {
            // If the remainder has been seen before, we found a recurring cycle
            if (seenRemainders.containsKey(remainder)) {
                int openParenthesisIndex = seenRemainders.get(remainder);
                result.insert(openParenthesisIndex, "(");
                result.append(")");
                return result.toString();
            }
            
            // Record the current remainder and its corresponding position in the string
            seenRemainders.put(remainder, result.length());
            
            // Multiply remainder by 10 to get the next digit (classic long division)
            remainder *= 10;
            result.append(remainder / den);
            
            // Update the remainder
            remainder %= den;
        }
        
        return result.toString();
    }
}
