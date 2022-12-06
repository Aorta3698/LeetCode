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
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>(List.of(root));
        int ans = 0, max = Integer.MIN_VALUE, level = 1;
        while(!queue.isEmpty()){
            int sz = queue.size(), sum = 0;
            while(--sz >= 0){
                TreeNode cur = queue.poll();
                sum += cur.val;
                if (cur.right != null) queue.offer(cur.right);
                if (cur.left  != null) queue.offer(cur.left );
            }
            if (sum > max){
                max = sum;
                ans = level;
            }

            level++;
        }

        return ans;
    }
}
