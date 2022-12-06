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
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        // if (root == null) return null;
        int r = depth(root.right);
        int l = depth(root.left);
        if (r == l){
            return root;
        }
        TreeNode ans = r > l?
            lcaDeepestLeaves(root.right) : lcaDeepestLeaves(root.left);

        return ans;
    }

    private int depth(TreeNode root){
        if (root == null) return 0;
        return Math.max(depth(root.right), depth(root.left)) + 1;
    }
}
