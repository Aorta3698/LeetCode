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
https://leetcode.com/problems/construct-binary-tree-from-string/discuss/1805928/Java-Simple-Recursive-Solution.
class Solution {
    public TreeNode str2tree(String s) {
        return build(s, 0, s.length() - 1);
    }

    private TreeNode build(String s, int lo, int hi){
        if (lo > hi) return null;

        int[] front = cut(s, lo, hi);
        int[] back  = cut(s, front[1] + 2, hi);

        TreeNode root = new TreeNode(Integer.parseInt(s.substring(lo, front[0] - 1)));
        root.left = build(s, front[0], front[1]);
        root.right= build(s, back[0] , back[1] );
        return root;
    }

    private int[] cut(String s, int lo, int hi){
        int l = hi + 1, r = hi + 1, open = 0;
        while(lo <= hi){
            if (s.charAt(lo) == '(' && ++open == 1) l = lo;
            if (s.charAt(lo) == ')' && --open == 0) r = lo;
            if (l != hi + 1 && r != hi + 1) break;
            lo++;
        }

        return new int[]{l + 1, r - 1};
    }
}
