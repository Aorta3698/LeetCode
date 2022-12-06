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
    public List<Integer> getLonelyNodes(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        find(root, ans);
        return ans;
    }

    private void find(TreeNode root, List<Integer> ans){
        if (root == null) return;

        find(root.right, ans);
        find(root.left, ans);

        if (root.left == null && root.right != null) ans.add(root.right.val);
        if (root.left != null && root.right == null) ans.add(root.left.val);
    }
}
