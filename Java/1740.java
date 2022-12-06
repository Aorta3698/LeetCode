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
    public int findDistance(TreeNode root, int p, int q) {
        return solve(ancestor(root, p, q), p, q);
    }

    private TreeNode ancestor(TreeNode root, int p, int q){
        if (root == null || root.val == p || root.val == q)
            return root;
        TreeNode l = ancestor(root.left , p, q);
        TreeNode r = ancestor(root.right, p, q);
        if (l != null && r != null)
            return root;
        return l != null? l : r;
    }

    private int solve(TreeNode root, int p, int q){
        if (root == null)
            return -1;
        int l = solve(root.left , p, q);
        int r = solve(root.right, p, q);
        if (l >= 0 && r >= 0)
            return l + r + 2;
        if (l >= 0)
            return ++l;
        if (r >= 0)
            return ++r;
        return root.val == p || root.val == q?
            0 : -1;
    }
}
