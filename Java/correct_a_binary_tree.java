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
    public TreeNode correctBinaryTree(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>(List.of(root));
        Map<TreeNode, TreeNode> map = new HashMap<>();
        while(!queue.isEmpty()){
            TreeNode cur = queue.poll();
            if (cur.right != null) {
                if (map.put(cur.right, cur) != null){
                    TreeNode parent = map.get(cur);
                    if (parent.right == cur) parent.right = null;
                    if (parent.left  == cur) parent.left  = null;
                    break;
                }
                queue.offer(cur.right);
            }
            if (cur.left  != null) queue.offer(cur.left);
            map.put(cur.left, cur);
        }

        return root;
    }
}
