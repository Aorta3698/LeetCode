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
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> ans = new ArrayList<>();
        solve(root, ans, new HashMap<>());
        return ans;
    }

    private StringBuilder solve(TreeNode root, List<TreeNode> ans, Map<String, Integer> seen){
        if (root == null)
            return new StringBuilder();
        StringBuilder cur = new StringBuilder();
        cur.append(solve(root.left, ans, seen));
        cur.append('l');
        cur.append(solve(root.right, ans, seen));
        cur.append('r');
        cur.append(root.val);
        cur.append('|');
        if (seen.merge(cur.toString(), 1, Integer::sum) == 2){
            ans.add(root);
        }
        return cur;
    }
}
