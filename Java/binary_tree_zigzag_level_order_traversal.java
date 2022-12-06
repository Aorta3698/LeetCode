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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) return List.of();
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        boolean even = false;
        while(!queue.isEmpty()){
            int size = queue.size();
            // List<Integer> l = new ArrayList<>();
            LinkedList<Integer> l = new LinkedList<>();
            for (int i = 0; i < size; i++){
                TreeNode cur = queue.poll();
                if (cur == null) continue;

                if(even)l.addFirst(cur.val);
                else l.addLast(cur.val);

                queue.offer(cur.left);
                queue.offer(cur.right);
            }
            // if (even) Collections.reverse(l);
            if(!l.isEmpty()) ans.add(l);
            even = !even;
        }

        return ans;
    }
}
