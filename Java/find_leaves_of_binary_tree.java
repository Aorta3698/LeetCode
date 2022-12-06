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
    public List<List<Integer>> findLeaves(TreeNode root) {
        HashMap<TreeNode, List<TreeNode>> map = new HashMap<>();
        HashMap<TreeNode, Integer> indeg = new HashMap<>();
        Queue<TreeNode> mapQueue = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        mapQueue.offer(root);
        while(!mapQueue.isEmpty()){
            TreeNode cur = mapQueue.poll();
            int childCount = 0;

            if (cur.right != null){
                map.computeIfAbsent(cur.right, o -> new ArrayList<>()).add(cur);
                mapQueue.offer(cur.right);
                childCount++;
            }

            if (cur.left != null){
                map.computeIfAbsent(cur.left, o -> new ArrayList<>()).add(cur);
                mapQueue.offer(cur.left);
                childCount++;
            }

            indeg.merge(cur, childCount, Integer::sum);
            if (childCount == 0) queue.offer(cur);
        }

        List<List<Integer>> ans = new ArrayList<>();
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            while(size-- > 0){
                TreeNode cur = queue.poll();
                level.add(cur.val);
                for (TreeNode parent : map.getOrDefault(cur, Collections.emptyList()))
                    if (indeg.merge(parent, -1, Integer::sum) == 0)
                        queue.offer(parent);
            }
            ans.add(level);
        }

        return ans;
    }
}
