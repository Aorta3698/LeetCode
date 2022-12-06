/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        build(root, map);
        Queue<Integer> queue = new ArrayDeque<>(List.of(target.val));
        List<Integer> ans = new ArrayList<>();
        boolean[] seen = new boolean[501];
        while(!queue.isEmpty() && k >= 0){
            int sz = queue.size();
            while(--sz >= 0){
                int cur = queue.poll();
                if (seen[cur]) continue;
                seen[cur] = true;
                if (k == 0) ans.add(cur);
                for (int next : map.getOrDefault(cur, Collections.emptyList())){
                    queue.offer(next);
                }
            }
            k--;
        }

        return ans;
    }

    private void build(TreeNode root, Map<Integer, List<Integer>> map){
        if (root == null) return;
        if (root.right != null){
            map.computeIfAbsent(root.val, o -> new ArrayList<>()).add(root.right.val);
            map.computeIfAbsent(root.right.val, o -> new ArrayList<>()).add(root.val);
        }
        if (root.left != null){
            map.computeIfAbsent(root.val, o -> new ArrayList<>()).add(root.left.val);
            map.computeIfAbsent(root.left.val, o -> new ArrayList<>()).add(root.val);
        }
        build(root.right, map);
        build(root.left , map);
    }
}
