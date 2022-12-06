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
    public int widthOfBinaryTree(TreeNode root) {
        long ans = 0;
        Queue<Node> queue = new ArrayDeque<>(List.of(new Node(root, 0L)));
        while(!queue.isEmpty()){
            int sz = queue.size();
            long start = Long.MAX_VALUE;
            while(--sz >= 0){
                TreeNode node = queue.peek().node;
                long pos = queue.poll().pos;
                if (node.left != null){
                    start = Math.min(2L * pos, start);
                    queue.offer(new Node(node.left, 2 * pos - start));
                }
                if (node.right != null){
                    start = Math.min(2L * pos + 1, start);
                    queue.offer(new Node(node.right, 2 * pos + 1L - start));
                }
                if (sz == 0) ans = Math.max(ans, pos + 1L);
            }
        }

        return (int)ans;
    }

    private class Node{
        TreeNode node;
        long pos;
        Node(TreeNode node, long pos){
            this.node = node;
            this.pos  = pos;
        }
    }
}
