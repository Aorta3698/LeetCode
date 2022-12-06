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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        TreeNode cur = root;
        while (!stack.isEmpty() || cur != null){
            if (cur != null){
                stack.push(cur);
                cur = cur.left;
            }else{
                cur = stack.pop();
                ans.add(cur.val);
                cur = cur.right;
            }
        }

        return ans;
        // return helper(root, new ArrayList<>());
    }

    // private List<Integer> helper(TreeNode node, List<Integer> l){
    //     if (node == null) return List.of();
    //     if (node.left != null) helper(node.left, l);
    //     l.add(node.val);
    //     if (node.right != null) helper(node.right, l);

    //     return l;
    // }
}
