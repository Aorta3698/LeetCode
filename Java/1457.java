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
    public int pseudoPalindromicPaths (TreeNode root) {
        return solve(0, root);
    }

    private int solve(int cur, TreeNode root){
        if (root == null)
            return 0;
        cur ^= (1 << root.val);
        if (root.right == root.left)
            return cur == 0 || (cur & (cur - 1)) == 0? 1 : 0;
        return solve(cur, root.right) + solve(cur, root.left);
    }
}
