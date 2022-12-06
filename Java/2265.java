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
    public int averageOfSubtree(TreeNode root) {
        return solve(root)[2];
    }

    private int[] solve(TreeNode root){
        if (root == null)
            return new int[3];
        int[] r = solve(root.right);
        int[] l = solve(root.left);
        int[] res = new int[]{r[0]+l[0]+root.val, r[1]+l[1]+1, r[2]+l[2]};
        if (res[0]/res[1] == root.val){
            res[2]++;
        }
        return res;
    }
}
