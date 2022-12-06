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
    long sum = 0;
    long cnt = 1;
    public double maximumAverageSubtree(TreeNode root) {
        dfs(root, 1000000001);
        return (double) sum / cnt;
    }

    private long dfs(TreeNode root, int base){
        if (root == null) return 0;
        long r = dfs(root.right, base), l = dfs(root.left, base);
        long rn = r % base, ln = l % base;
        long rs = r / base, ls = l / base;
        long ts = rs + ls + root.val, tn = 1 + rn + ln;
        if (ts * cnt > sum * tn){sum = ts; cnt = tn;}
        return ts * base + tn;
    }
}
