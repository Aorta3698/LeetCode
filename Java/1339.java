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
    long max = 0;
    public int maxProduct(TreeNode root) {
        long sum = sum(root);
        dfs(root, sum);
        return (int)(max % (int)(1e9+7));
    }

    private long sum(TreeNode root){
        if (root == null) return 0;
        return root.val + sum(root.right) + sum(root.left);
    }

    private long dfs(TreeNode root, long sum){
        if (root == null) return 0;
        long r = dfs(root.right, sum);
        long l = dfs(root.left , sum);
        long t = r + l + root.val;
        if (t * (sum - t) > max){
            max = t * (sum - t);
        }
        return t;
    }
}
