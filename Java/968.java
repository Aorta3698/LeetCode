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
    int OK = 1;
    int CAM = 2;
    int LEAF = 3;
    int ans = 0;
    public int minCameraCover(TreeNode root) {
        return dfs(root)==LEAF? ++ans : ans;
    }

    private int dfs(TreeNode root){
        if (root == null){
            return OK;
        }
        int r = dfs(root.right);
        int l = dfs(root.left);
        if (r == LEAF || l == LEAF){
            ans++;
            return CAM;
        }
        if (r == CAM || l == CAM){
            return OK;
        }
        return LEAF;
    }
}
