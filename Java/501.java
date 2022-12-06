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
    private int prev, cnt, max;
    private List<Integer> ans = new ArrayList<>();
    public int[] findMode(TreeNode root) {
        prev = root.val;
        cnt = 0;
        max = 1;
        inorder(root);
        return ans.stream().mapToInt(o -> o).toArray();
    }

    private void inorder(TreeNode root){
        if (root == null) return;
        inorder(root.left);

        if (root.val == prev && ++cnt > 0){
            if (cnt == max) ans.add(root.val);
            if (cnt > max) {max = cnt; ans.clear(); ans.add(prev);}
        }else{
            cnt = 1;
            if (cnt == max) ans.add(root.val);
        }

        prev = root.val;

        inorder(root.right);
    }
}
