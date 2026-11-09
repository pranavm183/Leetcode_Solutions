/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
import java.util.ArrayList;
import java.util.List;

class Solution {
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        
        flattenTree(root, list);
        
        int n = list.size();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (list.get(i) + list.get(j) == k) {
                    return true;
                }
            }
        }
        
        return false; 
    }
    
    private void flattenTree(TreeNode root, List<Integer> list) {
        if (root == null) return;
        
        list.add(root.val);
        flattenTree(root.left, list);
        flattenTree(root.right, list);
    }
}
