class Solution {
    public int longestPalindrome(String s) {
        int n=s.length();
        boolean[] used=new boolean[n];
        int length=0;
        for(int i=0;i<n;i++){
            if(used[i])continue;
            for(int j=i+1;j<n;j++){
                if(!used[j]&&s.charAt(i)==s.charAt(j)){
                    used[i]=true;
                    used[j]=true;
                    length=length+2;
                    break;
                }
            }
        }
        if(length<n){
            length+=1;
        }
        return length;
    }
}