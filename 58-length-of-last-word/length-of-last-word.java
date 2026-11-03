class Solution {
    public int lengthOfLastWord(String s) {
        String cleaned=s.trim();
        int ans=cleaned.lastIndexOf(" ")+1;
        int length=0;
        for(int i=ans;i<cleaned.length();i++){
            length++;
        }
        return length;
    }
}