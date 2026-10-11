class Solution {
    public String reverseWords(String s) {
        
        String strs[]=s.split("\\s+");

        String ans="";
        for(int i=0;i<strs.length;i++){
            ans=strs[i]+" "+ans;
        }
        return ans.trim();
    }
}