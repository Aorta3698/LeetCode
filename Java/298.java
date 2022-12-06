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
    public int longestConsecutive(TreeNode root) {
        dfs(root);
        return ans;
    }

    private int dfs(TreeNode root){
        if (root == null) return 0;
        int r = dfs(root.right);
        int l = dfs(root.left);
        int cur = 1;
        if (r > 0 && root.val - root.right.val == -1) cur += r;
        if (l > 0 && root.val - root.left .val == -1) cur += l;
        if (cur - r - l == 1) cur -= Math.min(r, l);

        ans = Math.max(cur, ans);
        return cur;
    }
}
