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
        if (root == q || root == p || root == null){
            return root;
        }
        TreeNode r = lowestCommonAncestor(root.right, p, q);
        TreeNode l = lowestCommonAncestor(root.left , p, q);
        if (l != null && r != null){
            return root;
        }
        return r == null? l : r;
    }
}
