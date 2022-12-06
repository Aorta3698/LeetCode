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
    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>(List.of(root));
        int d = 0;
        while(!queue.isEmpty()){
            int sz = queue.size();
            int prev = d % 2 == 0? 0 : Integer.MAX_VALUE;
            while(--sz >= 0){
                TreeNode cur = queue.poll();
                if (d % 2 == 0 && (cur.val % 2 == 0 || cur.val <= prev)) return false;
                if (d % 2 == 1 && (cur.val % 2 == 1 || cur.val >= prev)) return false;
                prev = cur.val;
                if (cur.left != null){
                    queue.offer(cur.left);
                }
                if (cur.right!= null){
                    queue.offer(cur.right);
                }
            }
            d++;
        }
        return true;
    }
}
