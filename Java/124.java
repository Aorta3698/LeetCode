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
https://leetcode.com/problems/binary-tree-maximum-path-sum/discuss/2211737/Kadane's-Algo-or-Java
class Solution {
    int ans = -100000000;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return ans;
    }

    private int dfs(TreeNode root){
        if (root == null){
            return 0;
        }
        int r = Math.max(root.val, dfs(root.right) + root.val);
        int l = Math.max(root.val, dfs(root.left)  + root.val);
        ans = Math.max(r+l-root.val, ans);
        return Math.max(r, l);
    }
}
