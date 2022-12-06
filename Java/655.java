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
    public List<List<String>> printTree(TreeNode root) {
        int height = height(root);
        String[][] ans = new String[height][(1 << height) - 1];
        for (int i = 0; i < height; i++){
            for (int j = 0; j < ans[0].length; j++){
                ans[i][j] = "";
            }
        }
        build(root, 0, (ans[0].length - 1)/2, ans);
        return Arrays.stream(ans).map(Arrays::asList).toList();
    }
    private void build(TreeNode root, int row, int col, String[][] ans){
        if (root == null) return;
        ans[row][col] += root.val;
        build(root.left , row + 1, col - (1 << (ans.length - row - 2)), ans);
        build(root.right, row + 1, col + (1 << (ans.length - row - 2)), ans);
    }

    private int height(TreeNode root){
        if (root == null) return 0;
        return 1 + Math.max(height(root.right), height(root.left));
    }
}
