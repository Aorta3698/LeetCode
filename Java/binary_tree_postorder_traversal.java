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
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> ans = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();

        TreeNode cur = root;
        while(!stack.isEmpty() || cur != null){
            if (cur != null){
                ans.addFirst(cur.val);
                stack.push(cur);
                cur = cur.right;
            }else{
                cur = stack.pop();
                cur = cur.left;
            }
        }

        return ans;
        // return helper(root, new ArrayList<>());
    }

    // private List<Integer> helper(TreeNode node, List<Integer> l){
    //     if (node == null) return List.of();
    //     if (node.left != null) helper(node.left, l);
    //     if (node.right != null) helper(node.right, l);
    //     l.add(node.val);

    //     return l;
    // }
}
