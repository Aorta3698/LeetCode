/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        return inorder(original, cloned, target);
    }

    private TreeNode inorder(TreeNode A, TreeNode B, TreeNode target){
        if (A == null)
            return null;
        if (A == target)
            return B;
        TreeNode l = inorder(A.left, B.left, target);
        TreeNode r = inorder(A.right,B.right,target);
        return l == null? r : l;
    }
}
