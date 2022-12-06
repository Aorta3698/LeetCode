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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(root, ans, new ArrayList<>(), targetSum);
        return ans;
    }

    private void dfs(TreeNode root, List<List<Integer>> ans, List<Integer> tmp, int remain){
        if (root == null){
            return;
        }

        remain -= root.val;
        tmp.add(root.val);

        if (root.right == root.left && remain == 0){
            ans.add(new ArrayList<>(tmp));
        }

        dfs(root.left , ans, tmp, remain);
        dfs(root.right, ans, tmp, remain);
        tmp.remove(tmp.size() - 1);
    }
}
