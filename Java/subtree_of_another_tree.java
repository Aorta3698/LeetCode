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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        String s = preOrderTraversal(subRoot);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            TreeNode cur = queue.poll();
            if (cur == null) continue;
            if (cur.val == subRoot.val && s.equals(preOrderTraversal(cur)))
                return true;
            queue.offer(cur.left);
            queue.offer(cur.right);
        }

        return false;
    }

    private String preOrderTraversal(TreeNode root){
        StringBuilder sb = new StringBuilder();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()){
            TreeNode cur = stack.pop();
            if (cur == null) sb.append(cur);
            else sb.append(cur.val);

            if (cur == null) continue;
            stack.push(cur.right);
            stack.push(cur.left);
        }

        return sb.toString();
    }
}
