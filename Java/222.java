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
https://leetcode.com/problems/count-complete-tree-nodes/discuss/1789974/Java-or-BS-or-Better-than-O(n)-or-0ms-or-Explained.
class Solution {
    public int countNodes(TreeNode root) {
        int lvl = 0;
        TreeNode cur = root;
        while(cur != null){
            cur = cur.left;
            lvl++;
        }
        int lo = 1, hi = (int)Math.pow(2, lvl - 1), tp = hi - 1;
        while(lo < hi){
            cur = root;
            int mid = lo + (hi - lo + 1) / 2;
            int pos = mid, ttl = tp + 1;
            while(ttl > 1){
                ttl >>= 1;
                if (pos > ttl){
                    pos -= ttl;
                    cur = cur.right;
                }else{
                    cur = cur.left;
                }
            }
            if (cur != null) lo = mid;
            else hi = mid - 1;
        }

        return tp + lo;
    }
}
