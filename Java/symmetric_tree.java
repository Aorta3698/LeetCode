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
    public boolean isSymmetric(TreeNode root) {
        ArrayList<Integer> r = new ArrayList<>();
        ArrayList<Integer> l = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        stack.push(root.left);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            if (node == null){
                l.add(null);
                continue;
            }
            l.add(node.val);
            stack.push(node.right);
            stack.push(node.left);
        }

        stack.push(root.right);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            if (node == null){
                r.add(null);
                continue;
            }
            r.add(node.val);
            stack.push(node.left);
            stack.push(node.right);
        }

        return r.equals(l);
    }
}
