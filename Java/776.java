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
https://leetcode.com/problems/split-bst/discuss/1812100/Java-or-Share-my-Solution
class Solution {
    public TreeNode[] splitBST(TreeNode root, int target) {
        return new TreeNode[]{less(root, target), more(root, target)};
    }

    private TreeNode less(TreeNode root, int target){
        if (root == null) return null;
        TreeNode copy = new TreeNode(root.val);
        copy.right = less(root.right, target);
        copy.left  = less(root.left , target);
        return copy.val <= target? copy : copy.left;
    }

    private TreeNode more(TreeNode root, int target){
        if (root == null) return null;
        TreeNode copy = new TreeNode(root.val);
        copy.right = more(root.right, target);
        copy.left  = more(root.left , target);
        return copy.val > target? copy : copy.right;
    }
}
