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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++)
            map.put(inorder[i], i);

        AtomicInteger idx = new AtomicInteger(0);
        return build(preorder, idx, map, 0, inorder.length-1);
    }

    private TreeNode build(int[] preorder, AtomicInteger idx,
            Map<Integer, Integer> map, int low, int high){

        if (low > high) return null;

        int val = preorder[idx.getAndIncrement()];
        TreeNode root = new TreeNode(val);

        int pivot = map.get(val);
        root.left = build(preorder, idx, map, low, pivot-1);
        root.right = build(preorder, idx, map, pivot+1, high);

        return root;
    }

}
