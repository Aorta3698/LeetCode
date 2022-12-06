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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        dfs(root, 0, ans);
        return ans;
    }
    private void dfs(TreeNode root, int lvl, List<Integer> ans){
        if (root == null) return;
        if (ans.size() <= lvl){
            ans.add(root.val);
        }
        dfs(root.right,lvl + 1, ans);
        dfs(root.left, lvl + 1, ans);
    }
}
