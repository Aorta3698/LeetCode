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
https://leetcode.com/problems/binary-tree-upside-down/discuss/1788443/Java-5-Lines-Recursion.
class Solution {
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        return mess(root, null, null);
    }

    private TreeNode mess(TreeNode root, TreeNode parent, TreeNode right){
        if (root == null) return null;
        TreeNode head = mess(root.left , root, root.right);
        root.right = parent;
        root.left = right;
        return head == null? root : head;
    }
}
