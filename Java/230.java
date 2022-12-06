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
    public int kthSmallest(TreeNode root, int k) {
        return solve(root, new int[]{k});
    }

    private int solve(TreeNode root, int[] count){
        if (root == null)
            return -1;
        int l = solve(root.left, count);
        if (l > -1)
            return l;
        if (--count[0] == 0)
            return root.val;
        int r = solve(root.right, count);
        if (r > -1)
            return r;
        return -1;
    }
}

// class Solution {
//     public int kthSmallest(TreeNode root, int k) {
//         PriorityQueue<Integer> maxheap = new PriorityQueue<>(Comparator.reverseOrder());
//         inorder(root, k, maxheap);
//         return maxheap.peek();
//     }

//     private static void inorder(TreeNode root, int k, PriorityQueue<Integer> maxheap){
//         if (root == null) return;
//         inorder(root.left, k, maxheap);
//         maxheap.offer(root.val);
//         if (maxheap.size() > k) maxheap.poll();
//         inorder(root.right, k, maxheap);
//     }
// }
