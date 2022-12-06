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
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        helper(root, targetSum, new ArrayList<>());
        return ans;
    }

    private void helper(TreeNode root, int target, List<Integer> l){
        if (root == null) return;

        l.add(root.val);

        if (root.val == target && root.right == null && root.left == null){
            ans.add(l);
        }

        List<Integer> copyR = new ArrayList<>(l);
        List<Integer> copyL = new ArrayList<>(l);

        helper(root.right, target-root.val, copyR);
        helper(root.left, target-root.val, copyL);
    }
}
