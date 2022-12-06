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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode cur = root;

        while(!stack.isEmpty() || cur != null){
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }

            cur = stack.pop();
            if (cur.val > val){
                list.add(val);
                val = Integer.MAX_VALUE;
            }
            list.add(cur.val);
            cur = cur.right;
        }
        if (val < Integer.MAX_VALUE) list.add(val);

        return build(list, 0, list.size() - 1);
    }

    private TreeNode build(List<Integer> list, int lo, int hi){
        if (lo > hi) return null;
        int mid = lo + (hi - lo) / 2;
        TreeNode root = new TreeNode(list.get(mid));
        root.left = build(list, lo, mid - 1);
        root.right= build(list, mid + 1, hi);

        return root;
    }
}
