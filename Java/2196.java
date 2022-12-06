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
    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode> map = new HashMap<>();
        Map<Integer, Integer> up = new HashMap<>();
        for (int[] d : descriptions){
            up.put(d[1], d[0]);
            TreeNode cur = map.getOrDefault(d[1], new TreeNode(d[1]));
            map.putIfAbsent(d[0], new TreeNode(d[0]));
            map.putIfAbsent(d[1], cur);
            if (d[2] == 1) {
                map.get(d[0]).left = cur;
            }else{
                map.get(d[0]).right = cur;
            }
        }
        int root = descriptions[0][0];
        while(up.containsKey(root)){
            root = up.get(root);
        }
        return map.get(root);
    }
}
