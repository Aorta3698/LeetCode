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
    public List<TreeNode> generateTrees(int n) {
        return solve(1, n);
    }

    private List<TreeNode> solve(int lo, int hi){
        List<TreeNode> ans = new ArrayList<>();
        if (lo > hi){
            ans.add(null);
            return ans;
        }
        for (int i = lo; i <= hi; i++){
            for (TreeNode l : solve(lo, i-1)){
                for (TreeNode r : solve(i+1, hi)){
                    ans.add(new TreeNode(i, l, r));
                }
            }
        }
        return ans;
    }
}
