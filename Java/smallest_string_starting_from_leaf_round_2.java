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
    public String smallestFromLeaf(TreeNode root) {
        //round 1 is actually a much better solution lol.
        //but it is good to figure out other ways to do it.
        List<String> ans = gen(root);
        Collections.sort(ans);
        return ans.get(0);
    }

    private List<String> gen(TreeNode root){
        if (root == null) return new ArrayList<>();
        char letter = (char)('a' + root.val);
        List<String> children = gen(root.right);
        children.addAll(gen(root.left));
        if (children.isEmpty())
            return new ArrayList<>(List.of(String.valueOf(letter)));

        List<String> ans = new ArrayList<>();
        for (String path : children){
            StringBuilder sb = new StringBuilder();
            sb.append(path);
            sb.append(letter);
            ans.add(sb.toString());
        }

        return ans;
    }
}
