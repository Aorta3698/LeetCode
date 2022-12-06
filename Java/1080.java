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
    public TreeNode sufficientSubset(TreeNode root, int limit) {
        return cut(root, 0, limit)? null : root;
    }

    private boolean cut(TreeNode root, int sum, int limit){
        if (root == null)
            return true;
        sum += root.val;
        if (root.right == root.left)
            return sum < limit;
        if (cut(root.right, sum, limit)){
            root.right = null;
        }
        if (cut(root.left , sum, limit)){
            root.left = null;
        }
        return root.right == root.left;
    }
}
