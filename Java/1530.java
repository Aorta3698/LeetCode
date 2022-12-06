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
    public int countPairs(TreeNode root, int distance) {
        return solve(root, distance)[11];
    }

    private int[] solve(TreeNode root, int dist){
        int[] ans = new int[12];
        if (root == null)
            return ans;
        if (root.right == root.left){
            ans[1] = 1;
            return ans;
        }
        int[] l = solve(root.left , dist);
        int[] r = solve(root.right, dist);
        ans[11] = l[11] + r[11];
        for (int i = 1; i <= dist; i++){
            for (int j = 1; i+j <= dist; j++){
                ans[11] += l[i] * r[j];
            }
        }
        for (int i = 1; i < 9; i++){
            ans[i+1] = l[i]+r[i];
        }

        return ans;
    }
}
