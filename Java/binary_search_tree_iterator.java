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
class BSTIterator {
    List<Integer> data;
    Iterator<Integer> iter;

    public BSTIterator(TreeNode root) {
        data = new ArrayList<>();
        TreeNode cur = root;
        Stack<TreeNode> stack = new Stack<>();
        while(!stack.isEmpty() || cur != null){
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }

            cur = stack.pop();
            data.add(cur.val);
            cur = cur.right;
        }

        iter = data.iterator();
    }

    public int next() {
        return iter.next();
    }

    public boolean hasNext() {
        return iter.hasNext();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
