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
    public boolean isCousins(TreeNode root, int x, int y) {
        int[] info = new int[4];
        find(root, 1, 0, x, y, info);
        return info[0] == info[2] && info[1] != info[3];
        // int[] xx = find(root, 0, 0, x);
        // int[] yy = find(root, 0, 0, y);
        // return xx[0] == yy[0] && xx[1] != yy[1];
    }

    private static void find(TreeNode root, int d, int p, int x, int y, int[] info){
        if (root == null) return;
        if (root.val == x){info[0] = d; info[1] = p;}
        if (root.val == y){info[2] = d; info[3] = p;}
        if (info[0] == 0 || info[2] == 0) find(root.right, d + 1, root.val, x, y, info);
        if (info[0] == 0 || info[2] == 0) find(root.left , d + 1, root.val, x, y, info);
    }

    // private static int[] find(TreeNode root, int d, int p, int n){
    //     if (root == null) return null;
    //     if (root.val ==n) return new int[]{d, p};
    //     int[] r = find(root.right, d + 1, root.val, n);
    //     if (r != null) return r;

    //     return find(root.left , d + 1, root.val, n);
    // }
}
