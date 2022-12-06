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
    public boolean isSymmetric(TreeNode root) {
        return check(root.right, root.left);
    }

    private boolean check(TreeNode r, TreeNode l){
        if (r == l)
            return true;
        if (r == null || l == null || l.val != r.val)
            return false;
        return check(r.right, l.left) && check(l.right, r.left);
    }
}
