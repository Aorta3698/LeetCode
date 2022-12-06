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
    int max = 0;
    public int longestZigZag(TreeNode root) {
        dfs(root, 0);
        return max;
    }

    private int dfs(TreeNode root, int dir){
        if (root == null) return 0;
        int r = dfs(root.right, 1);
        int l = dfs(root.left, -1);
        max = Math.max(max, Math.max(r, l));
        return dir == 1? ++l : ++r;
    }
}
