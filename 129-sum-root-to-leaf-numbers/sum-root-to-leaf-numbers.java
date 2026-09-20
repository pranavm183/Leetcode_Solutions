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
    public int sumNumbers(TreeNode root) {
        // Start the DFS traversal with an initial sum of 0
        return dfs(root, 0);
    }

    private int dfs(TreeNode root, int currentSum) {
        // Base case: if the node is null, it contributes 0 to the sum
        if (root == null) {
            return 0;
        }

        // Update the current path number
        currentSum = currentSum * 10 + root.val;

        // If it's a leaf node, return the completed path number
        if (root.left == null && root.right == null) {
            return currentSum;
        }

        // Recursively sum up the values from both left and right subtrees
        int leftSum = dfs(root.left, currentSum);
        int rightSum = dfs(root.right, currentSum);

        return leftSum + rightSum;
    }
}
