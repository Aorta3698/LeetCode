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
    public boolean isValidSequence(TreeNode root, int[] arr) {
        return solve(0, root, arr);
    }

    private boolean solve(int i, TreeNode root, int[] arr){
        if (root == null || i == arr.length || arr[i] != root.val)
            return false;
        if (root.right == root.left && i == arr.length - 1)
            return true;
        return solve(i + 1, root.right, arr) || solve(i + 1, root.left, arr);
    }
}
