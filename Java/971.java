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
https://leetcode.com/problems/flip-binary-tree-to-match-preorder-traversal/discuss/1841119/java-flip-whenever-we-need-to-comments
class Solution {
    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        List<Integer> ans = new ArrayList<>();
        Queue<Integer> queue = new ArrayDeque<>();
        for (int v : voyage) queue.offer(v);
        dfs(root, queue, ans);
        return queue.isEmpty()? ans : List.of(-1);
    }

    private boolean dfs(TreeNode root, Queue<Integer> queue, List<Integer> ans){
        if (root == null) return true;
        if (root.val != queue.peek()) return false;
        queue.poll();

        if (!dfs(root.left, queue, ans)){
            ans.add(root.val);
            flip(root);
            if (!dfs(root.left, queue, ans)) return false;
        }
        if (!dfs(root.right, queue, ans)){
            ans.add(root.val);
            flip(root);
            if (dfs(root.right, queue, ans)) return false;
        }

        return true;
    }

    private void flip(TreeNode root){
        TreeNode tmp = root.right;
        root.right = root.left;
        root.left  = tmp;
    }
}
