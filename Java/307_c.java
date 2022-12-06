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
    int res = 0;
    public int amountOfTime(TreeNode root, int start) {
        dfs(root, start);
        return res;
    }

    int[] dfs(TreeNode root, int start){
        if (root == null){
            return new int[2];
        }
        int[] L = dfs(root.left, start);
        int[] R = dfs(root.right, start);
        int[] ans = new int[2];
        if (root.val == start){
            ans[1] = ans[0] = 1;
            res = Math.max(L[0], R[0]);
            return ans;
        }
        if (R[1] == 1 || L[1] == 1){
            ans[1] = 1;
            res = Math.max(res, L[0] + R[0]);
            ans[0] = R[1] == 1? R[0] : L[0];
        }else{
            ans[0] = Math.max(R[0], L[0]);
        }
        ans[0]++;
        return ans;
    }
}
