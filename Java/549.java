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

    private int[] dfs(TreeNode root){
        if (root == null) return null;
        int[] r = dfs(root.right);
        int[] l = dfs(root.left);
        int[] cur = new int[]{1, 1};
        int dr = r != null? root.val - root.right.val : 0;
        int dl = l != null? root.val - root.left.val : 0;
        if (dr == 1) cur[0] += r[0];
        if (dl == 1) cur[0] += l[0];
        if (dr == 1 && dl == 1) cur[0] -= Math.min(r[0], l[0]);
        if (dr == -1)cur[1] += r[1];
        if (dl == -1)cur[1] += l[1];
        if (dr == -1 && dl == -1) cur[1] -= Math.min(r[1], l[1]);

        ans = Math.max(cur[0] + cur[1] - 1, ans);
        return cur;
    }
}
