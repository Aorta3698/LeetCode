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
    public void recoverTree(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        int s = Integer.MAX_VALUE, t = -1;
        get(list, root);
        for (int i = 1; i < list.size(); i++){
            if (list.get(i - 1).val > list.get(i).val){
                s = Math.min(s, i - 1);
                t = i;
            }
        }
        int tmp = list.get(s).val;
        list.get(s).val = list.get(t).val;
        list.get(t).val = tmp;
    }

    private void get(List<TreeNode> list, TreeNode root){
        if (root == null) return;
        get(list, root.left);
        list.add(root);
        get(list, root.right);
    }
}
