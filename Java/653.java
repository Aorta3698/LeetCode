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
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> all = new ArrayList<>();
        inorder(root, all);
        int lo = 0, hi = all.size() - 1;
        while(lo < hi){
            int sum = all.get(lo) + all.get(hi);
            if (sum == k) return true;
            if (sum < k) lo++;
            if (sum > k) hi--;
        }

        return false;
    }

    private void inorder(TreeNode root, List<Integer> all){
        if (root == null) return;
        inorder(root.left, all);
        all.add(root.val);
        inorder(root.right,all);
    }
}
