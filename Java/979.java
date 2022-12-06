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
    int ans = 0;
    public int distributeCoins(TreeNode root) {
        dfs(root);
        return ans;
    }

    private int dfs(TreeNode root){
        if (root == null) return 0;
        int r = dfs(root.right);
        int l = dfs(root.left);
        ans = ans + Math.abs(r) + Math.abs(l);
        return root.val + r + l - 1;
    }
}
