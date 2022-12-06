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
        return build(1, n);
    }

    private List<TreeNode> build(int sIdx, int eIdx){
        List<TreeNode> ans = new ArrayList<>();
        if (sIdx > eIdx){
            ans.add(null);
            return ans;
        }

        for (int i = sIdx; i <= eIdx; i++){
            for (TreeNode left : build(sIdx, i - 1)){
                for (TreeNode right : build(i + 1, eIdx)){
                    TreeNode root = new TreeNode(i);
                    root.right = right;
                    root.left = left;
                    ans.add(root);
                }
            }
        }
        return ans;
    }
}
