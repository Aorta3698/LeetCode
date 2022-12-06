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
https://leetcode.com/problems/delete-nodes-and-return-forest/discuss/1651257/Java-PreOrder-Recursive-Solution-10-Lines-Explained.
class Solution {
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> ans = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (int t : to_delete) set.add(t);
        preorder(root, set , ans, true);
        return ans;
    }

    private static boolean preorder(TreeNode root, Set<Integer> delete, List<TreeNode> ans, boolean isRoot){
        if (root == null) return false;
        if (isRoot && !delete.contains(root.val)) ans.add(root);
        isRoot = delete.contains(root.val);
        if (preorder(root.left , delete, ans, isRoot)) root.left = null;
        if (preorder(root.right, delete, ans, isRoot)) root.right= null;
        return isRoot;
    }
}
