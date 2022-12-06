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
class CBTInserter {

    private Queue<TreeNode> queue;
    private TreeNode root;
    public CBTInserter(TreeNode root) {
        queue = new ArrayDeque<>();
        Queue<TreeNode> processingQueue = new ArrayDeque<>(List.of(root));
        while(!processingQueue.isEmpty()){
            TreeNode cur = processingQueue.poll();
            if (cur.left == null || cur.right == null) queue.offer(cur);
            if (cur.left != null) processingQueue.offer(cur.left);
            if (cur.right!= null) processingQueue.offer(cur.right);
        }
        this.root = root;
    }

    public int insert(int val) {
        TreeNode node = new TreeNode(val);
        int ans = -1;
        if (queue.peek().left == null) {
            queue.peek().left = node;
            ans = queue.peek().val;
        }
        else if (queue.peek().right == null) {
            queue.peek().right = node;
            ans = queue.poll().val;
        }

        queue.offer(node);
        return ans;
    }

    public TreeNode get_root() {
        return root;
    }
}

/**
 * Your CBTInserter object will be instantiated and called as such:
 * CBTInserter obj = new CBTInserter(root);
 * int param_1 = obj.insert(val);
 * TreeNode param_2 = obj.get_root();
 */
