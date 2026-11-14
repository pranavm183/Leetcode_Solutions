class Solution {
    public boolean isValid(String s) {
        String temp="{,},(,),[,]";
        if(s.length()%2!=0){
            return false;
        }
        int previousLength;
        do{
            previousLength=s.length();
            s=s.replace("()","").replace("[]","").replace("{}","");
        }while(s.length()!=previousLength);

        return s.isEmpty();
    }
}