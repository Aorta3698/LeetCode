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
    public int findClosestLeaf(TreeNode root, int k) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        build(map, root);
        return map.isEmpty()? root.val : dfs(map, root.val, k, -1)[1];
    }

    private int[] dfs(Map<Integer, List<Integer>> map, int root, int start, int parent){
        boolean isLeaf = map.get(start).size() == 1 && start != root;
        int[] max = isLeaf? new int[]{0, start} : new int[]{1001, -1};
        for (int next : map.get(start)){
            if (next == parent) continue;
            int[] res = dfs(map, root, next, start);
            if (max[0] > res[0]) max = res;
        }

        max[0]++;
        return max;
    }

    private void build(Map<Integer, List<Integer>> map, TreeNode root){
        if (root.right != null){
            map.computeIfAbsent(root.val, o -> new ArrayList<>()).add(root.right.val);
            map.computeIfAbsent(root.right.val, o -> new ArrayList()).add(root.val);
            build(map, root.right);
        }
        if (root.left != null){
            map.computeIfAbsent(root.val, o -> new ArrayList<>()).add(root.left.val);
            map.computeIfAbsent(root.left.val, o -> new ArrayList()).add(root.val);
            build(map, root.left);
        }
    }
}
