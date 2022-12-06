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
https://leetcode.com/problems/find-nearest-right-node-in-binary-tree/discuss/1632065/Java-or-One-Queue-BFS-or-9-Lines-or-Comments

class Solution {
    public TreeNode findNearestRightNode(TreeNode root, TreeNode u) {
        Queue<TreeNode> queue = new ArrayDeque<>(List.of(root));
        while(!queue.isEmpty()){
            int size = queue.size();
            while(--size >= 0){
                TreeNode cur = queue.poll();
                if (cur == u) return size > 0? queue.peek() : null;
                if (cur.left != null) queue.offer(cur.left);
                if (cur.right!= null) queue.offer(cur.right);
            }
        }

        return null;
    }
}
