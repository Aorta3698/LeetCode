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
https://leetcode.com/problems/binary-tree-vertical-order-traversal/discuss/1714659/Java-2-Solutions-or-Explained.
class Solution {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        int min = Integer.MAX_VALUE;
        Map<Integer, List<Integer>> map = new HashMap<>();
        Queue<Node> queue = new ArrayDeque<>(List.of(new Node(root, 0)));

        while(!queue.isEmpty()){
            Node cur = queue.poll();
            TreeNode tree = cur.node;
            map.computeIfAbsent(cur.position, o -> new ArrayList<>()).add(tree.val);
            if (tree.left != null) queue.offer(new Node(tree.left,  cur.position - 1));
            if (tree.right!= null) queue.offer(new Node(tree.right, cur.position + 1));
            min = Math.min(cur.position, min);
        }

        for (int i = min; i < map.size() + min; i++){
            ans.add(map.get(i));
        }

        return ans;
    }

    private class Node{
        TreeNode node;
        int position;

        Node(TreeNode node, int position){
            this.node = node;
            this.position = position;
        }
    }
}
