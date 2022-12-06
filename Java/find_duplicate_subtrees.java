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
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> ans = new ArrayList<>();
        hash(root, new HashMap<>(), ans);

        return ans;
    }

    private String hash(TreeNode root, Map<String, Integer> map
            , List<TreeNode> ans){

        if (root == null) return "x";

        StringBuilder sb = new StringBuilder();
        sb.append(hash(root.left, map, ans));
        sb.append('l');
        sb.append(hash(root.right, map, ans));
        sb.append('r');
        sb.append(root.val);

        String serial = sb.toString();
        map.put(serial, map.getOrDefault(serial, 0) + 1);
        if (map.get(serial) == 2){
            System.out.println(root.val);
            ans.add(root);
        }

        return serial;
    }
}
