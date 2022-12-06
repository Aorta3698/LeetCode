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
    int max = 0;
    public int[] findFrequentTreeSum(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        dfs(root, new HashMap<>(), ans);
        return ans.stream().mapToInt(o -> o).toArray();
    }

    int dfs(TreeNode root, Map<Integer, Integer> map, List<Integer> ans){
        if (root == null) return 0;
        int r = dfs(root.right, map, ans);
        int l = dfs(root.left , map, ans);
        int sum = root.val + r + l;
        if (map.merge(sum, 1, Integer::sum) > max){
            max++;
            ans.clear();
        }
        if (max == map.get(sum)){
            ans.add(sum);
        }
        return sum;
    }
}
