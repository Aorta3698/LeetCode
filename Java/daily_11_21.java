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
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        if (key > root.val) root.right = deleteNode(root.right, key);
        if (key < root.val) root.left = deleteNode(root.left, key);
        if (key == root.val){
            if (root.right == null) return root.left;
            TreeNode r = root.right;
            while(r.left != null) r = r.left;
            r.left = root.left;
            return root.right;
        }

        return root;
    }
}
