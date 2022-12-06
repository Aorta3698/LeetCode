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
    public void flatten(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        preorder(root, queue);
        while(queue.size() > 1){
            TreeNode cur = queue.poll();
            cur.right = queue.peek();
            cur.left = null;
        }
    }

    private void preorder(TreeNode root, Queue<TreeNode> queue){
        if (root == null) return;
        queue.offer(root);
        preorder(root.left , queue);
        preorder(root.right, queue);
    }
}
