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
    public String smallestFromLeaf(TreeNode root) {
        StringBuilder ans = new StringBuilder();
        uniqueP(root, new StringBuilder(), ans);
        return ans.toString();
    }

    private void uniqueP(TreeNode root, StringBuilder sb, StringBuilder ans){
        if (root == null) return;

        sb.append((char)('a' + root.val));
        if (root.right == null && root.left == null){
            sb.reverse();
            if (ans.length() == 0 || ans.compareTo(sb) > 0){
                ans.setLength(0);
                ans.append(sb);
            }
            sb.reverse();
        }

        uniqueP(root.right, sb, ans);
        uniqueP(root.left, sb, ans);
        sb.deleteCharAt(sb.length()-1);
    }
}
