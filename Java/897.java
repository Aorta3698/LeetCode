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
    public TreeNode increasingBST(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        traverse(root, queue);
        root = queue.peek();
        while(!queue.isEmpty()){
            TreeNode cur = queue.poll();
            cur.left = null;
            cur.right = queue.peek();
        }
        return root;
    }

    private void traverse(TreeNode root, Queue<TreeNode> queue){
        if (root == null)
            return;
        traverse(root.left, queue);
        queue.offer(root);
        traverse(root.right, queue);
    }
}
