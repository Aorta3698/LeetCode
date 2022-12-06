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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);

        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> layer = new ArrayList<>();

            for (int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                if (node == null) continue;
                layer.add(node.val);
                queue.offer(node.left);
                queue.offer(node.right);
            }

            if(!layer.isEmpty()) ans.add(layer);
        }

        return ans;
    }
}
