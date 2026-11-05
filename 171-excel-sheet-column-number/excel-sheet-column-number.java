class Solution {
    public int titleToNumber(String columnTitle) {
        int result = 0;

        for (int i = 0; i < columnTitle.length(); i++) {
            char targetChar = columnTitle.charAt(i);
            int charValue = 0;

            for (char c = 'A'; c <= 'Z'; c++) {
                charValue++;
                if (c == targetChar) {
                    break;
                }
            }

            result = (result * 26) + charValue;
        }

        return result;
    }
}
