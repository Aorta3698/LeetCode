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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ans = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int size = queue.size(), t = queue.size();
            double sum = 0;
            while(--size >= 0){
                TreeNode cur = queue.poll();
                sum += cur.val;
                if (cur.right != null) queue.offer(cur.right);
                if (cur.left  != null) queue.offer(cur.left );
            }
            ans.add(sum/t);
        }

        return ans;
    }
}
