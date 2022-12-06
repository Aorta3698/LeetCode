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
    public TreeNode pruneTree(TreeNode root) {
        return remove(root)? null : root;
    }

    private boolean remove(TreeNode root){
        if (root == null) return true;
        boolean r = remove(root.right);
        boolean l = remove(root.left);
        if (r) root.right = null;
        if (l) root.left  = null;
        return root.val == 0 && r && l;
    }
}
