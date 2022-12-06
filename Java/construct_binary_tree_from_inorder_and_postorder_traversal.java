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
        HashMap<Integer, Integer> map = new HashMap<>();
        AtomicInteger idx = new AtomicInteger(postorder.length-1);

        for (int i = 0; i < inorder.length; i++)
            map.put(inorder[i], i);

        return build(postorder, idx, map, 0, inorder.length-1);
    }

    private TreeNode build(int[] postorder, AtomicInteger idx,
            Map<Integer, Integer> map, int low, int high){

        if (low > high) return null;

        int val = postorder[idx.getAndDecrement()];
        TreeNode root = new TreeNode(val);

        int pivot = map.get(val);
        root.right = build(postorder, idx, map, pivot+1, high);
        root.left = build(postorder, idx, map, low, pivot-1);

        return root;
    }
}
