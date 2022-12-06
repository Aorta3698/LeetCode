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
        return solve(root, new StringBuilder());
    }

    private String solve(TreeNode root, StringBuilder sb){
        if (root == null)
            return "";
        sb.append((char)(root.val + 'a'));
        String r = solve(root.right, sb);
        String l = solve(root.left , sb);
        if (r.isEmpty() && l.isEmpty()){
            String ans = sb.reverse().toString();
            sb.reverse();
            sb.setLength(sb.length() - 1);
            return ans;
        }
        sb.setLength(sb.length() - 1);
        if (!r.isEmpty() && !l.isEmpty())
            return r.compareTo(l) < 0? r : l;
        else
            return r.isEmpty()? l : r;
    }
}
