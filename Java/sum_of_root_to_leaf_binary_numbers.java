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
https://leetcode.com/problems/sum-of-root-to-leaf-binary-numbers/discuss/1633820/Java-or-5-Lines-and-0ms-or-Explained.
class Solution {
    public int sumRootToLeaf(TreeNode root) {
        return getSum(root, 0);
    }

    private int getSum(TreeNode root, int val){
        if (root == null) return 0;
        val <<= 1;
        val += root.val;
        int sum = getSum(root.right, val) + getSum(root.left, val);
        return sum == 0? val : sum;
    }
}
