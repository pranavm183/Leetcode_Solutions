class Solution {
     public boolean isPalindrome(int x) {
         int temp1=x;
         int rev=0;
          if(x<0)return false; 
          while(x!=0){ 
            int temp = x%10;
             
             rev=(rev*10)+temp;
             x=x/10; 
         }
          if(rev==temp1)return true;
           return false; 
           } 
     }