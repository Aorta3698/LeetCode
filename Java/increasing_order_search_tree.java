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
    public TreeNode increasingBST(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode nRoot = null;
        TreeNode prev = null;
        while(root != null || !stack.isEmpty()){
            while(root != null){
                stack.push(root);
                root = root.left;
            }

            if (prev != null && !stack.isEmpty()) prev.right = stack.peek();
            root = stack.pop();
            if (nRoot == null) nRoot = root;
            root.left = null;
            prev = root;
            root = root.right;
        }

        return nRoot;
    }
}
