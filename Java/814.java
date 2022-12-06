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
        return contain(root)? root : null;
    }

    private boolean contain(TreeNode root){
        if (root == null)
            return false;
        if (!contain(root.left)){
            root.left = null;
        }
        if (!contain(root.right)){
            root.right = null;
        }
        return root.val == 1 || root.right != null || root.left != null;
    }
}
