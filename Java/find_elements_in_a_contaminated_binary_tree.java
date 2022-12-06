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
class FindElements {

    private HashSet<Integer> seen;
    private int max;
    private Queue<TreeNode> queue;
    public FindElements(TreeNode root) {
        seen = new HashSet<>(Set.of(0));
        queue = new LinkedList<>();
        root.val = 0;
        max = 0;
        queue.offer(root);
    }

    public boolean find(int target) {
        if (seen.contains(target)) return true;
        if(!seen.contains(target) && max >= target) return false;

        while(!queue.isEmpty()){
            TreeNode cur = queue.poll();
            if (cur == null) continue;
            max = cur.val;
            seen.add(cur.val);
            if (cur.left != null) {
                cur.left.val = cur.val * 2 + 1;
                queue.offer(cur.left);
            }

            if (cur.right != null){
                cur.right.val = cur.val * 2 + 2;
                queue.offer(cur.right);
            }

            if (cur.val == target) return true;
            if (max >= target) return false;
        }

        return false;
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */
