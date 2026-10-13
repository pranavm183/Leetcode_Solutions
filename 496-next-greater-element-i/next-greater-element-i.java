import java.util.HashMap;
import java.util.Stack;

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> greaterMap = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        
        for (int num : nums2) {
           
            while (!stack.isEmpty() && num > stack.peek()) {
                int poppedValue = stack.pop();
                greaterMap.put(poppedValue, num);
            }
            stack.push(num);
        }
       
        int[] ans = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            ans[i] = greaterMap.getOrDefault(nums1[i], -1);
        }
        
        return ans;
    }
}
