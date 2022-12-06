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
    public int sumOfLeftLeaves(TreeNode root) {
        return helper(root, false);
    }

    private int helper(TreeNode root, boolean isLeft){
        if (root == null) return 0;
        if (isLeft && root.left == null && root.right == null)
            return root.val;

        return helper(root.left, true) + helper(root.right, false);
    }
}
