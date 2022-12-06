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
    public boolean isValidBST(TreeNode root) {
        return ok(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    boolean ok(TreeNode root, long min, long max){
        return root == null
            || root.val > min && root.val < max
            && ok(root.left, min, root.val)
            && ok(root.right, root.val, max);
    }
}
