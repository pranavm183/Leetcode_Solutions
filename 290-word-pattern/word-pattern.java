import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        
        // If lengths don't match, the pattern can't match
        if (pattern.length() != words.length) {
            return false;
        }
        
        Map<Character, String> charToWord = new HashMap<>();
        Set<String> usedWords = new HashSet<>();
        
        for (int i = 0; i < pattern.length(); i++) {
            char ch = pattern.charAt(i);
            String word = words[i];
            
            if (charToWord.containsKey(ch)) {
                // Check if the existing mapping matches the current word
                if (!charToWord.get(ch).equals(word)) {
                    return false;
                }
            } else {
                // If the character is new, the word must also be new
                if (usedWords.contains(word)) {
                    return false;
                }
                charToWord.put(ch, word);
                usedWords.add(word);
            }
        }
        
        return true;
    }
}
