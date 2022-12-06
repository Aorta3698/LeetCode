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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }

    private TreeNode build(int[] nums, int lo, int hi){
        if (lo > hi) return null;

        int idx = 0;
        int max = Integer.MIN_VALUE;
        for (int i = lo; i <= hi; i++){
            if (max < nums[i]){
                max = nums[i];
                idx = i;
            }
        }

        TreeNode root = new TreeNode(nums[idx]);
        root.left = build(nums, lo, idx - 1);
        root.right = build(nums, idx + 1, hi);

        return root;
    }
}
