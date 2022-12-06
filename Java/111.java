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
    int cnt = 0;
    public int minDepth(TreeNode root) {
        if (root == null) return cnt == 0? 0 : Integer.MAX_VALUE;

        ++cnt;
        int r = minDepth(root.right);
        int l = minDepth(root.left);
        if (r == Integer.MAX_VALUE && l == r) return 1;

        return 1 + Math.min(r, l);
    }
}
