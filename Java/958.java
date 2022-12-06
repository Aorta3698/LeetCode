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
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>(List.of(root));
        boolean last = false;
        while(!queue.isEmpty()){
            TreeNode cur = queue.poll();
            if (cur.left != null){
                if (last) return false;
                queue.offer(cur.left);
            }else{
                last = true;
            }
            if (cur.right != null){
                if (last) return false;
                queue.offer(cur.right);
            }else{
                last = true;
            }
        }
        return true;
    }
}
