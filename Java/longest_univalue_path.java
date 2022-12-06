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
    public int longestUnivaluePath(TreeNode root) {
        AtomicInteger ans = new AtomicInteger(0);
        find(root, ans);

        return ans.intValue();
    }

    private int find(TreeNode root, AtomicInteger ans){
        if (root == null) return 0;

        int l = 0;
        int r = 0;
        if (root.right!= null){
            r = find(root.right, ans) + 1;
            if (root.right.val != root.val)
                r = 0;
        }

        if (root.left!= null){
            l = find(root.left, ans) + 1;
            if (root.left.val != root.val)
                l = 0;
        }

        ans.set(Math.max(ans.intValue(), r+l));
        return Math.max(r, l);
    }

}
