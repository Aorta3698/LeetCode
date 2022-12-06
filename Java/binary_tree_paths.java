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
    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) return new ArrayList<>();

        List<String> children = binaryTreePaths(root.right);
        children.addAll(binaryTreePaths(root.left));

        if (children.isEmpty())
            return new ArrayList<>(List.of(String.valueOf(root.val)));

        List<String> ans = new ArrayList<>();
        for (String s : children){
            StringBuilder sb = new StringBuilder();
            sb.append(root.val);
            sb.append("->");
            sb.append(s);
            ans.add(sb.toString());
        }

        return ans;
    }
}
