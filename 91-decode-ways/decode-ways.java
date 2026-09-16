public class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }

        int n = s.length();
        int twoBack = 1; 
        int oneBack = 1; 

        for (int i = 1; i < n; i++) {
            int current = 0;
            char prevChar = s.charAt(i - 1);
            char currChar = s.charAt(i);

            if (currChar != '0') {
                current += oneBack;
            }

            if (prevChar == '1' || (prevChar == '2' && currChar <= '6')) {
                current += twoBack;
            }

            if (current == 0) {
                return 0;
            }

            twoBack = oneBack;
            oneBack = current;
        }

        return oneBack;
    }
}
