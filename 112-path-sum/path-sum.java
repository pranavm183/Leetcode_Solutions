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
class Solution {
   
    public boolean hasPathSum(TreeNode root, int targetSum) {
       return path(root,targetSum);
        
    }
    public boolean path(TreeNode root,int targetSum){
        if(root==null)return false;
        targetSum=targetSum-root.val;
        if(targetSum==0 && root.left==null && root.right==null)return true;

        boolean left=path(root.left,targetSum);
        boolean right=path(root.right,targetSum);
        return left||right;
    }
}