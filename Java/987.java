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
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int st = dfs(0, 0, root, map)+1; map.containsKey(st); st++){
            List<Integer> cur = map.get(st);
            Collections.sort(cur);
            for (int i = 0; i < cur.size(); i++){
                cur.set(i, cur.get(i)%1000);
            }
            ans.add(cur);
        }
        return ans;
    }

    private int dfs(int hori, int vert, TreeNode root, Map<Integer, List<Integer>> map){
        if (root == null)
            return hori;
        map.computeIfAbsent(hori, o -> new ArrayList<>()).add(root.val+1000*vert);
        return Math.min(dfs(hori-1, vert+1, root.left, map), dfs(hori+1, vert+1, root.right, map));
    }
}

https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/discuss/1714712/java-similar-to-314
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        List<int[]> data = new ArrayList<>();
        dfs(root, 0, 0, data);
        data.sort((a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            if (a[1] != b[1]) return a[1] - b[1];
            return a[2] - b[2];
        });

        int prev = (int)1e5;
        for (int[] d : data){
            if (prev != d[0]){
                prev = d[0];
                List<Integer> list = new ArrayList<>();
                list.add(d[2]);
                ans.add(list);
            }else{
                ans.get(ans.size() - 1).add(d[2]);
            }
        }

        return ans;
    }

    private void dfs(TreeNode root, int d, int p, List<int[]> data){
        if (root == null) return;
        data.add(new int[]{p, d, root.val});
        dfs(root.left, d + 1, p - 1, data);
        dfs(root.right,d + 1, p + 1, data);
    }
}
