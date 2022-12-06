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
    int ans = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        AtomicInteger ans = new AtomicInteger(0);
        helper(root, ans);
        // Queue<TreeNode> queue = new LinkedList<>();
        // add(root, queue);

        // while(!queue.isEmpty())
        //     helper(queue.poll(), ans, true);

        return ans.getAndIncrement();
    }

    private int helper(TreeNode root, AtomicInteger ans){
        if (root == null) return 0;

        int r = root.right == null? 0 : helper(root.right, ans) + 1;
        int l = root.left == null? 0: helper(root.left, ans) + 1;

        ans.set(Math.max(ans.intValue(), r+l));

        return Math.max(r, l);
    }

    // private int helper(TreeNode root, AtomicInteger ans, boolean isFirst){
    //     if (root == null) return 0;

    //     int r = root.right == null? 0 : helper(root.right, ans, false) + 1;
    //     int l = root.left == null? 0: helper(root.left, ans, false) + 1;

    //     int max = isFirst? r+l : Math.max(r, l);
    //     ans.set(Math.max(ans.intValue(), max));

    //     return max;
    // }

    // private void add(TreeNode root, Queue<TreeNode> queue){
    //     if (root == null) return;
    //     queue.offer(root);
    //     add(root.right, queue);
    //     add(root.left, queue);
    // }
}
