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
https://leetcode.com/problems/evaluate-boolean-binary-tree/discuss/2260764/Java-or-Switch
class Solution {
    public boolean evaluateTree(TreeNode root) {
        return switch(root.val){
            case 0: yield false;
            case 1: yield true;
            case 2: yield evaluateTree(root.right)|evaluateTree(root.left);
            default: yield evaluateTree(root.right)&evaluateTree(root.left);
        };
    }
}
