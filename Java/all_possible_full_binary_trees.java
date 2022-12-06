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
    HashMap<Integer, List<TreeNode>> map = new HashMap<>();
    public List<TreeNode> allPossibleFBT(int n) {
        if (n == 1) return new ArrayList<>(List.of(new TreeNode(0)));
        if (map.containsKey(n)) return map.get(n);
        List<TreeNode> ans = new ArrayList<>();
        if (n % 2 == 0) return ans;

        for (int i = 1; i < n; i+=2){
            List<TreeNode> l = allPossibleFBT(i);
            List<TreeNode> r = allPossibleFBT(n - i - 1);

            for (TreeNode a : l)
                for (TreeNode b : r){
                    TreeNode root = new TreeNode(0, a, b);
                    ans.add(root);
                }
        }

        map.put(n, ans);
        return ans;
    }
}
