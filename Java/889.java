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
https://leetcode.com/problems/construct-binary-tree-from-preorder-and-postorder-traversal/discuss/1812417/Java-O(n)-Clean-Solutions
class Solution {
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        int n = postorder.length;
        int[] post = new int[n + 1];
        for (int i = 0; i < n; i++){
            post[postorder[i]] = i; // quick lookup array
        }
        Queue<Integer> queue = new ArrayDeque<>();
        for (int p : preorder){
            queue.offer(p);
        }
        return build(queue, queue.peek(), preorder, post);
    }

    private TreeNode build(Queue<Integer> queue, int parent, int[] pre, int[] post){
        if (queue.isEmpty()) return null;
        if (post[queue.peek()] > post[parent]) return null;

        TreeNode root = new TreeNode(queue.poll());
        root.left  = build(queue, root.val, pre, post);
        root.right = build(queue, root.val, pre, post);

        return root;
    }
}
