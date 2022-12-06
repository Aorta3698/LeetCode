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
    public int equalToDescendants(TreeNode root) {
        sum(root);
        return ans;
    }

    private int sum(TreeNode root){
        if (root == null) return 0;
        int lVal = sum(root.left);
        int rVal = sum(root.right);
        if (root.val == lVal + rVal) ans++;

        return lVal + rVal + root.val;
    }
}
