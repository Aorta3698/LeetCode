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
https://leetcode.com/problems/maximum-difference-between-node-and-ancestor/discuss/1657423/Java-or-2-Solutions-or-Thinking-Process
class Solution {
    public int maxAncestorDiff(TreeNode root) {
        return find(root, root.val, root.val);
    }

    private int find(TreeNode root, int min, int max){
        if (root == null) return max - min;
        min = Math.min(root.val, min);
        max = Math.max(root.val, max);
        int r = find(root.right, min, max);
        int l = find(root.left , min, max);
        return Math.max(r, l);
    }
}
class Solution {
    int ans = 0;
    public int maxAncestorDiff(TreeNode root) {
        find(root, root.val);
        return ans;
    }

    private int[] find(TreeNode root, int p){
        if (root == null) return new int[]{p, p};
        int[] r = find(root.right, root.val);
        int[] l = find(root.left , root.val);
        int max = Math.max(r[0], l[0]);
        int min = Math.min(r[1], l[1]);
        int cand= Math.max(Math.abs(root.val - min), Math.abs(root.val - max));
        ans = Math.max(cand, ans);
        return new int[]{Math.max(root.val, max), Math.min(root.val, min)};
    }
}
