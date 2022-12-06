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
    public int closestValue(TreeNode root, double target) {
        if (root == null) return Integer.MAX_VALUE;
        if (root.right == null && root.left == null) return root.val;

        int l = closestValue(root.left, target);
        int r = closestValue(root.right, target);
        double disL = Math.abs(target - l);
        double disR = Math.abs(target - r);
        int cand = disL >= disR? r : l;
        double disC = Math.abs(target - root.val);

        return Math.abs(target-cand) >= disC? root.val : cand;
    }
}
