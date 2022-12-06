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
    int[] nums;
    public TreeNode sortedArrayToBST(int[] nums) {
        this.nums=nums;
        return build(0, nums.length-1);
    }

    private TreeNode build(int lo, int hi){
        return lo > hi? null : new TreeNode(nums[(lo+hi)>>1], build(lo, (lo+hi)/2-1), build((lo+hi)/2+1, hi));
    }
}
