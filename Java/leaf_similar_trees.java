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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> one = new ArrayList<>(), two = new ArrayList<>();
        inorder(root1, one);
        inorder(root2, two);
        return one.equals(two);
    }

    private boolean inorder(TreeNode root, List<Integer> leaf){
        if (root == null) return true;
        boolean l = inorder(root.left, leaf);
        boolean r = inorder(root.right, leaf);
        if (l && r) leaf.add(root.val);
        return false;
    }
}
