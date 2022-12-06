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
    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
        List<Integer> one = new ArrayList<>(), two = new ArrayList<>();
        inorder(root1, one);
        inorder(root2, two);
        int lo = 0, hi = two.size() - 1;
        while(lo < one.size() && hi >= 0){
            int cur = one.get(lo) + two.get(hi);
            if (cur == target) return true;
            if (cur < target) lo++;
            if (cur > target) hi--;
        }

        return false;
    }

    private static void inorder(TreeNode root, List<Integer> list){
        if (root == null) return;
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }
}
