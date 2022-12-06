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
    public String getDirections(TreeNode root, int startValue, int destValue) {
        StringBuilder sb = new StringBuilder();
        HashMap<Integer, List<Map.Entry<Integer, Character>>> map = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            TreeNode cur = queue.poll();
            if (cur.right != null){
                map.computeIfAbsent(cur.val, o -> new ArrayList<>()).add(Map.entry(cur.right.val, 'R'));
                map.computeIfAbsent(cur.right.val, o -> new ArrayList<>()).add(Map.entry(cur.val, 'U'));
                queue.offer(cur.right);
            }

            if (cur.left != null){
                map.computeIfAbsent(cur.val, o -> new ArrayList<>()).add(Map.entry(cur.left.val, 'L'));
                map.computeIfAbsent(cur.left.val, o -> new ArrayList<>()).add(Map.entry(cur.val, 'U'));
                queue.offer(cur.left);
            }
        }

        dfs(map, startValue, destValue, sb, new boolean[map.size() + 1]);
        return sb.reverse().toString();
    }

    private boolean dfs(HashMap<Integer, List<Map.Entry<Integer, Character>>> map, int start, int dest,
            StringBuilder sb, boolean[] seen){

        if (seen[start]) return false;
        if (start == dest) return true;

        seen[start] = true;
        for (Map.Entry<Integer, Character> n : map.get(start))
            if (dfs(map, n.getKey(), dest, sb, seen)){
                sb.append(n.getValue());
                return true;
            }

        return false;
    }
}
