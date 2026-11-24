class Solution {
    public int removeElement(int[] nums, int val) {
        int n=nums.length;
        int i=0;
        while(i<n){
            if(nums[i]==val){
                for(int j=i+1;j<n;j++){
                    nums[j-1]=nums[j];
                }
                n--;
            }
            else{
                i++;
            }
        }
        return n;
    }
}