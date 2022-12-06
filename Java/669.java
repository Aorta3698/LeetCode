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
    public TreeNode trimBST(TreeNode root, int low, int high) {
        return trim(root, low, high);
    }

    private static TreeNode trim(TreeNode root, int lo, int hi){
        if (root == null) return null;

        if (lo <= root.val && root.val <= hi){
            root.right = trim(root.right, lo, hi);
            root.left  = trim(root.left , lo, hi);
            return root;
        }

        return root.val < lo?
            trim(root.right, lo, hi) : trim(root.left, lo, hi);
    }
}

class Solution {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null)
            return null;
        root.right = trimBST(root.right, low, high);
        root.left = trimBST(root.left, low, high);
        if (root.val < low)
            return root.right;
        if (root.val > high)
            return root.left;
        return root;
    }
}
