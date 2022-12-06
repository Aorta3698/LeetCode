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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;

        Queue<TreeNode> queue = new ArrayDeque<>(List.of(root));
        while(!queue.isEmpty()){
            int sz = queue.size(), max = queue.peek().val;
            while(--sz >= 0){
                TreeNode cur = queue.poll();
                max = Math.max(cur.val, max);
                if (cur.right != null) queue.offer(cur.right);
                if (cur.left  != null) queue.offer(cur.left);
            }
            ans.add(max);
        }

        return ans;
    }
}
