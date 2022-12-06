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
https://leetcode.com/problems/maximum-sum-bst-in-binary-tree/discuss/2212754/java-or-post-order-DFS-or-save-4-states-(BST-sum-max-min)
class Solution {
    int res;
    int VALID = 0;
    public int maxSumBST(TreeNode root) {
        dfs(root);
        return res;
    }

    // valid, sum, min, max;
    private int[] dfs(TreeNode root){
        if (root == null){
            return new int[]{VALID, 0, Integer.MAX_VALUE, Integer.MIN_VALUE};
        }
        int[] r = dfs(root.right);
        int[] l = dfs(root.left);
        int[] ans = new int[4];
        ans[0] = r[0]==VALID&&l[0]==VALID&&root.val < r[2] && root.val > l[3]? VALID : 1;
        ans[1] = r[1]+l[1]+root.val;
        ans[2] = Math.min(root.val, l[2]);
        ans[3] = Math.max(root.val, r[3]);
        if (ans[0]==VALID){
            res = Math.max(ans[1], res);
        }
        return ans;
    }
}
