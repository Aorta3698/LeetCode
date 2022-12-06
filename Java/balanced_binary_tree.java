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
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        return getDepth(root) != -1;
    }

    private int getDepth(TreeNode root){
        if (root == null) return 0;
        int r = getDepth(root.right);
        int l = getDepth(root.left);
        return (r >= 0 && l >= 0 && Math.abs(r-l) <= 1)? Math.max(r, l) + 1 : -1;
    }
}
