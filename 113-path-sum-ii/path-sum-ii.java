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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<>();
        
        // Start the recursive tracking from the root
        dfs(root, targetSum, currentPath, result);
        
        return result;
    }
    
    private void dfs(TreeNode node, int remainingSum, List<Integer> currentPath, List<List<Integer>> result) {
        // Base case: if the node is null, return immediately
        if (node == null) {
            return;
        }
        
        // Choose: Add the current node's value to our working path
        currentPath.add(node.val);
        
        // Check if the current node is a leaf and matches the target condition
        if (node.left == null && node.right == null && remainingSum == node.val) {
            // Found a valid path; create a snapshot copy to save in results
            result.add(new ArrayList<>(currentPath));
        } else {
            // Explore: Recursively traverse down the left and right subtrees
            dfs(node.left, remainingSum - node.val, currentPath, result);
            dfs(node.right, remainingSum - node.val, currentPath, result);
        }
        
        // Un-choose (Backtrack): Remove the current node before returning up the call stack
        currentPath.remove(currentPath.size() - 1);
    }
}
