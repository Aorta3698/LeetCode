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
    int n = 0;
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        int[] cnt = new int[100];
        dfs(root1, cnt);
        return check(root2, cnt) && n == 0;
    }

    private void dfs(TreeNode root, int[] cnt){
        if (root == null) return;
        cnt[root.val] = hash(root);
        n++;
        dfs(root.left, cnt);
        dfs(root.right, cnt);
    }

    private boolean check(TreeNode root, int[] cnt){
        if (root == null) return true;
        if (cnt[root.val] != hash(root)) return false;
        n--;
        return check(root.right, cnt) && check(root.left, cnt);
    }

    private int hash(TreeNode root){
        int r = root.right == null? 0 : root.right.val + 1;
        int l = root.left  == null? 0 : root.left.val  + 1;
        return Math.max(r, l) * 101 + Math.min(r, l);
    }
}
