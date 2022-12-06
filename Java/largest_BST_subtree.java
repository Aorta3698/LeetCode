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
    public int largestBSTSubtree(TreeNode root) {
        if (isBST(root, Integer.MAX_VALUE, Integer.MIN_VALUE)) return getCount(root);
        return Math.max(largestBSTSubtree(root.left), largestBSTSubtree(root.right));
    }

    private boolean isBST(TreeNode root, int hi, int lo){
        if (root == null) return true;
        if (root.val >= hi || root.val <= lo) return false;
        return isBST(root.right, hi, root.val) && isBST(root.left, root.val, lo);
    }

    private int getCount(TreeNode root){
        if (root == null) return 0;
        return 1 + getCount(root.left) + getCount(root.right);
    }
}
