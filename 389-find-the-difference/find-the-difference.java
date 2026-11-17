class Solution {
    public char findTheDifference(String s, String t) {
        char[] sChars = s.toCharArray();
        
        for (int i = 0; i < t.length(); i++) {
            char target = t.charAt(i);
            boolean found = false;
            
            for (int j = 0; j < sChars.length; j++) {
                if (sChars[j] == target) {
                    sChars[j] = '#'; 
                    found = true;
                    break;
                }
            }
            
            if (!found) {
                return target;
            }
        }
        
        return ' ';
    }
}
