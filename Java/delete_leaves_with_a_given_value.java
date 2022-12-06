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
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        return remove(root, target)? null : root;
    }

    private boolean remove(TreeNode root, int target){
        if (root == null) return true;
        if (remove(root.right, target)) root.right = null;
        if (remove(root.left , target)) root.left  = null;
        if (root.val == target && root.right == null && root.left == null)
            return true;

        return false;
    }
}
