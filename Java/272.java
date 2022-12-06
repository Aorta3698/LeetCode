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
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> ans = new ArrayList<>();
        PriorityQueue<Integer> maxheap = new PriorityQueue<>(
                Comparator.comparingDouble(o -> -Math.abs(1.0*o - target)));
        traverse(root, maxheap, k);
        while(!maxheap.isEmpty()){
            ans.add(maxheap.poll());
        }
        return ans;
    }

    private void traverse(TreeNode root, PriorityQueue<Integer> maxheap, int k){
        if (root == null)
            return;
        maxheap.offer(root.val);
        if (maxheap.size() > k){
            maxheap.poll();
        }
        traverse(root.right, maxheap, k);
        traverse(root.left, maxheap, k);
    }
}
