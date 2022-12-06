/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root == p) return p;
        if (root == q) return q;

        TreeNode r = lowestCommonAncestor(root.right, p, q);
        TreeNode l = lowestCommonAncestor(root.left, p, q);

        if (r != null && l != null) return root;
        if (r == null && l == null) return null;
        if (r == null) return l;
        if (l == null) return r;
        return null;
    }
}
