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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            if (node == null) continue;
            ans.add(node.val);
            stack.push(node.right);
            stack.push(node.left);
        }

        return ans;
        
        // if (root == null) return List.of();
        // List<Integer> ans = new ArrayList<>();
        // return helper(root, ans);
    }

    // private List<Integer> helper(TreeNode node, List<Integer> list){
    //     list.add(node.val);
    //     if (node.left != null)
    //         helper(node.left, list);
    //     if (node.right != null)
    //         helper(node.right, list);

    //     return list;
    // }
}
