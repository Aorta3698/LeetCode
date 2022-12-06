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
    public int findSecondMinimumValue(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        Collections.sort(list);
        Set<Integer> set = new HashSet<>();
        for (int n : list){
            set.add(n);
            if (set.size() == 2)
                return n;
        }

        return -1;
    }

    private void inorder(TreeNode root, List<Integer> list){
        if (root == null) return;
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right,list);
    }
}
