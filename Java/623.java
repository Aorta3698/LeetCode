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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1){
            TreeNode newRoot = new TreeNode(val);
            newRoot.left = root;
            return newRoot;
        }

        int d = 1;
        Queue<TreeNode> queue = new ArrayDeque<>(List.of(root));
        while(!queue.isEmpty()){
            int sz = queue.size();
            while(--sz >= 0){
                TreeNode cur = queue.poll();
                if (depth - d == 1){
                    TreeNode node = new TreeNode(val);
                    node.left = cur.left;
                    cur.left = node;
                }
                else if (cur.left != null){
                    queue.offer(cur.left);
                }
                if (depth - d == 1){
                    TreeNode node = new TreeNode(val);
                    node.right = cur.right;
                    cur.right = node;
                }
                else if (cur.right!= null){
                    queue.offer(cur.right);
                }
            }
            if (++d == depth) break;
        }

        return root;
    }
}
