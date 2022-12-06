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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) return List.of();
        Deque<List<Integer>> ans = new ArrayDeque<>();
        Queue<TreeNode> queue = new ArrayDeque<>(List.of(root));
        while(!queue.isEmpty()){
            int sz = queue.size();
            List<Integer> lvl = new ArrayList<>();
            while(--sz >= 0){
                TreeNode cur = queue.poll();
                lvl.add(cur.val);
                if (cur.left != null) queue.offer(cur.left);
                if (cur.right!= null) queue.offer(cur.right);
            }
            ans.push(lvl);
        }

        return new ArrayList<>(ans);
    }
}
