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
    public int findTilt(TreeNode root) {
        if (root == null) return 0;

        int r = sum(root.right);
        int l = sum(root.left);
        return Math.abs(r - l) + findTilt(root.right) + findTilt(root.left);
    }

    private int sum(TreeNode root){
        if (root == null) return 0;
        return root.val + sum(root.left) + sum(root.right);
    }
}
