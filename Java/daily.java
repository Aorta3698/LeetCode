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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int len = inorder.length - 1;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++)
            map.put(inorder[i], i);

        return build(inorder, postorder, 0, len, new AtomicInteger(len), map);
    }

    private TreeNode build(int[] in, int[] post, int lo, int hi,
            AtomicInteger head, Map<Integer, Integer> map){
        if (lo > hi) return null;

        int val = post[head.getAndDecrement()];
        TreeNode root = new TreeNode(val);
        root.right = build(in, post, map.get(val) + 1, hi, head, map);
        root.left = build(in, post, lo, map.get(val) - 1,  head, map);

        return root;
    }
}
