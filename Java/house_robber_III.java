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
    public int rob(TreeNode root) {
        return rob(root, true);
    }

    HashMap<Map.Entry<TreeNode, Boolean>, Integer> seen = new HashMap<>();
    public int rob(TreeNode root, boolean canRob){
        if (root == null) return 0;
        if (seen.containsKey(Map.entry(root, canRob))) return seen.get(Map.entry(root, canRob));

        int val = canRob? root.val : 0;
        int max = Math.max(val + rob(root.left, !canRob) + rob(root.right, !canRob),
                rob(root.left, canRob) + rob(root.right, canRob));
        seen.put(Map.entry(root, canRob), max);

        return max;
    }
}
