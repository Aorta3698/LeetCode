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
    public TreeNode convertBST(TreeNode root) {
        update(root, new int[]{sum(root)});
        return root;
    }

    private void update(TreeNode root, int[] sum){
        if (root == null)
            return;
        update(root.left, sum);
        int tmp = root.val;
        root.val = sum[0];
        sum[0] -= tmp;
        update(root.right, sum);
    }

    private int sum(TreeNode root){
        if (root == null)
            return 0;
        return root.val + sum(root.right) + sum(root.left);
    }
}
