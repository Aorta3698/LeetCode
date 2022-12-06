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
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> values = new ArrayList<>();

        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode cur = root;
        while(!stack.isEmpty() || cur != null){
            while (cur != null){
                stack.push(cur);
                cur = cur.left;
            }

            cur = stack.pop();
            values.add(cur.val);
            cur = cur.right;
        }

        return build(values, 0, values.size() - 1);
    }

    private TreeNode build(List<Integer> values, int lo, int hi){
        if (lo > hi) return null;

        int mid = lo + (hi - lo) / 2;
        TreeNode root = new TreeNode(values.get(mid));
        root.left = build(values, lo, mid - 1);
        root.right= build(values, mid + 1, hi);

        return root;
    }
}
