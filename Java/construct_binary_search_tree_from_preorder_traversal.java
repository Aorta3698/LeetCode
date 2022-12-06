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
    public TreeNode bstFromPreorder(int[] preorder) {
        int idx = 0;
        TreeNode root = new TreeNode(preorder[idx++]);
        TreeNode cur = root;
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();

        while(idx < preorder.length){
            if (preorder[idx] < cur.val){
                cur.left = new TreeNode(preorder[idx++]);
                stack.push(cur);
                cur = cur.left;
                continue;
            }

            while (preorder[idx] > cur.val &&
                    !stack.isEmpty() && stack.peek().val < preorder[idx])
                cur = stack.pop();

            cur.right = new TreeNode(preorder[idx++]);
            cur = cur.right;
        }

        return root;
    }
}
