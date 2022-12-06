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
    public int countUnivalSubtrees(TreeNode root) {
        if (root == null) return 0;
        int count = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++){
                TreeNode cur = queue.poll();
                if (cur == null) continue;
                if (verify(cur)) count++;
                queue.offer(cur.left);
                queue.offer(cur.right);
            }
        }

        return count;
    }

    private boolean verify(TreeNode root){
        if (root == null) return false;
        Stack<TreeNode> stack = new Stack<>();
        HashSet<Integer> set = new HashSet<>();
        set.add(root.val);
        stack.push(root);

        while(!stack.isEmpty()){
            TreeNode cur = stack.pop();
            if (cur == null) continue;
            if (!set.contains(cur.val))
                return false;
            stack.push(cur.right);
            stack.push(cur.left);
        }

        return true;
    }
}
