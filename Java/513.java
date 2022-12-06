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
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>(List.of(root));
        while(true){
            TreeNode cur = queue.poll();
            if (cur.right != null) queue.offer(cur.right);
            if (cur.left  != null) queue.offer(cur.left );
            if (queue.isEmpty()) return cur.val;
        }
    }
}
