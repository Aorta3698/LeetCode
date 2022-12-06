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

https://leetcode.com/problems/binary-tree-coloring-game/discuss/1789863/Java-Simple-6-Lines-wo-Global-Variable
class Solution {
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        int[] ans = find(root, x);
        int need = (n+1)/2;
        return Math.max(ans[0], ans[1]) >= need || n - ans[0] - ans[1] - 1 >= need;
    }

    private int[] find(TreeNode root, int x){
        if (root == null)
            return new int[2];
        if (root.val == x)
            return new int[]{count(root.right), count(root.left)};
        int[] r = find(root.right, x);
        int[] l = find(root.left , x);
        return r[0] + r[1] > 0? r : l;
    }

    private int count(TreeNode root){
        return root == null? 0 :
        1 + count(root.right) + count(root.left);
    }
}

class Solution {
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        return dfs(root, n, x, false) > n / 2;
    }

    private int dfs(TreeNode root, int n, int x, boolean found){
        if (root == null) return 0;
        if (!found && x == root.val) found = true;
        int r = dfs(root.right, n, x, found);
        int l = dfs(root.left , n, x, found);
        if (x == root.val) return Math.max(Math.max(r, l), n - r - l - 1);
        return found? 1 + r + l : Math.max(r, l);
    }
}
