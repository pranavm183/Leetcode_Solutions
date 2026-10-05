public class Solution {
    public String removeDuplicateLetters(String s) {
        int[] lastIndex = new int[26];
        for (int i = 0; i < s.length(); i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }
        
        boolean[] seen = new boolean[26];
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            int currIdx = curr - 'a';
            
            if (seen[currIdx]) {
                continue;
            }
           
            while (sb.length() > 0 && sb.charAt(sb.length() - 1) > curr && lastIndex[sb.charAt(sb.length() - 1) - 'a'] > i) {
                seen[sb.charAt(sb.length() - 1) - 'a'] = false;
                sb.deleteCharAt(sb.length() - 1);
            }
            
            sb.append(curr);
            seen[currIdx] = true;
        }
        
        return sb.toString();
    }
}
