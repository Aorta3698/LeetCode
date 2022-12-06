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

    private int idx;
    private List<Integer> list;
    public BSTIterator(TreeNode root) {
        list = new ArrayList<>();
        idx = -1;
        inorder(root);
    }

    public boolean hasNext() {
        return idx < list.size() - 1;
    }

    public int next() {
        return list.get(++idx);
    }

    public boolean hasPrev() {
        return idx > 0;
    }

    public int prev() {
        return list.get(--idx);
    }

    private void inorder(TreeNode root){
        if (root == null) return;
        inorder(root.left);
        list.add(root.val);
        inorder(root.right);
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * boolean param_1 = obj.hasNext();
 * int param_2 = obj.next();
 * boolean param_3 = obj.hasPrev();
 * int param_4 = obj.prev();
 */
