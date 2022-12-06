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
        if (isValid(root, Integer.MAX_VALUE, Integer.MIN_VALUE)) return count(root);
        else return Math.max(largestBSTSubtree(root.right), largestBSTSubtree(root.left));
    }

    private int count(TreeNode root){
        if (root == null) return 0;
        return 1 + count(root.right) + count(root.left);
    }

    private boolean isValid(TreeNode root, int hi, int lo){
        if (root == null) return true;
        if (root.val >= hi || root.val <= lo) return false;
        return isValid(root.right, hi, root.val) && isValid(root.left, root.val, lo);
    }
}
