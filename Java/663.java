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
    int MAX = (int)(1e9)+1;
    public boolean checkEqualTree(TreeNode root) {
        int sum = sum(root);
        if ((sum & 1) == 1) return false;
        return check(root, sum, true) == sum / 2;
    }

    private int sum(TreeNode root){
        return root == null? 0 :
            root.val + sum(root.left) + sum(root.right);
    }

    private int check(TreeNode root, int sum, boolean isRoot){
        if (root == null) return MAX;
        int r = check(root.right, sum, false);
        int l = check(root.left , sum, false);
        if (2*r == sum || 2*l == sum){
            return sum / 2;
        }
        return isRoot? MAX :
               (r == MAX? 0 : r) +
               (l == MAX? 0 : l) +
               root.val;
    }
}
