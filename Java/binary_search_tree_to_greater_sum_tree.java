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
    public TreeNode bstToGst(TreeNode root) {
        // int sum = getSum(root);
        // update(root, new AtomicInteger(sum));
        // update(root, 0);

        // method 3: iterative solutoin. One pass.
        // Deque<TreeNode> stack = new ArrayDeque<>();
        // TreeNode cur = root;
        // int prev = 0;
        // while(!stack.isEmpty() || cur != null){
        //     while(cur != null){
        //         stack.push(cur);
        //         cur = cur.right;
        //     }
        //     cur = stack.pop();
        //     cur.val += prev;
        //     prev = cur.val;
        //     cur = cur.left;
        // }
        update(root, new AtomicInteger(0));
        return root;
    }

    // method 2: straight up doing inorder in reverse and update values. One Pass.
    private void update(TreeNode root, AtomicInteger prev){
        if (root == null) return;
        update(root.right, prev);
        root.val += prev.get();
        prev.set(root.val);
        update(root.left, prev);
    }

    // method 1: get the sum and go with inorder traversal. Two pass needed.
    // private int getSum(TreeNode root){
    //     if (root == null) return 0;
    //     int sum = root.val + getSum(root.left) + getSum(root.right);
    //     return sum;
    // }

    // private void update(TreeNode root, AtomicInteger nVal){
    //     if (root == null) return;
    //     update(root.left, nVal);
    //     int tmp = root.val;
    //     root.val = nVal.get();
    //     nVal.set(nVal.get() - tmp);
    //     update(root.right, nVal);
    // }
}
