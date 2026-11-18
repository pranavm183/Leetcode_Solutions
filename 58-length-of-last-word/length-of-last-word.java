class Solution {
    public int lengthOfLastWord(String s) {
        s=s.trim();
        int n=s.lastIndexOf(" ");
        String last=s.substring(n+1);
        return last.length();
    }
}