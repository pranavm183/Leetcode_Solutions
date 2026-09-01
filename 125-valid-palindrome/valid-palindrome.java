class Solution {
    public boolean isPalindrome(String s) {
        if(s == null){
            return true;
        }
        // Remove spaces, punctuation, and convert to lowercase for an accurate check
        String s1 = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        
        String reversedText = new StringBuilder(s1).reverse().toString();
        if(s1.equals(reversedText)){
            return true;
        }
        return false;
    }
}
