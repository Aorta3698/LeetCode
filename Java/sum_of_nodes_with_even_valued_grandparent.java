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
    public int sumEvenGrandparent(TreeNode root) {
        if (root == null) return 0;
        int sum = sumEvenGrandparent(root.right)
            + sumEvenGrandparent(root.left);
        if (root.val % 2 == 0) sum+=getSum(root, 0);
        return sum;
    }

    private int getSum(TreeNode root, int depth){
        if (root == null) return 0;
        if (depth == 2) return root.val;
        int sum = getSum(root.right, depth+1)
            + getSum(root.left, depth+1);
        return sum;
    }
}
