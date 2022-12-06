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
    public int deepestLeavesSum(TreeNode root) {
        int[] ans = new int[2];
        solve(0, root, ans);
        return ans[1];
    }

    private void solve(int depth, TreeNode root, int[] ans){
        if (root == null)
            return;
        if (depth > ans[0]){
            ans[0] = depth;
            ans[1] = 0;
        }
        if (depth == ans[0]){
            ans[1] += root.val;
        }
        solve(depth + 1, root.right, ans);
        solve(depth + 1, root.left , ans);
    }
}
