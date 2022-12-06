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
    public int pathSum(TreeNode root, int targetSum) {
        Map<Integer, Integer> map = new HashMap<>(Map.of(0, 1));
        return find(root, 0, targetSum, map);
    }

    private int find(TreeNode root, int sum, int target, Map<Integer, Integer> map){
        if (root == null) return 0;
        sum += root.val;
        int ans = map.getOrDefault(sum - target, 0);
        map.merge(sum, 1, Integer::sum);
        ans += find(root.right, sum, target, map);
        ans += find(root.left , sum, target, map);
        map.merge(sum, -1, Integer::sum);
        return ans;
    }
}
