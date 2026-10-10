class Solution {
    public void sortColors(int[] nums) {
          int idx=0;
          int zeroIdx=0;
          int twoIdx=nums.length-1;

          while(idx<=twoIdx){
            if(nums[idx]==2){
                int t=nums[idx];
                nums[idx]=nums[twoIdx];
                nums[twoIdx]=t;
                twoIdx--;
            }
            else if(nums[idx]==0){
                int t=nums[idx];
                nums[idx]=nums[zeroIdx];
                nums[zeroIdx]=t;
                zeroIdx++;
                idx++; 
            }
            else
                idx++;
          }
        
    }
}