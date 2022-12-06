/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {
        if (root == null || nodes == null || nodes.length == 0) return null;
        HashSet<Integer> set = new HashSet<>();
        for (TreeNode n : nodes)
            set.add(n.val);

        return helper(root, set);
        // if (root == null || nodes == null || nodes.length == 0) return null;
        // HashSet<Integer> set = new HashSet<>();
        // for (TreeNode n : nodes)
        //     set.add(n.val);

        // return helper(root, set);
    }

    private TreeNode helper(TreeNode root, HashSet<Integer> set){
        if (root == null) return null;
        if (set.contains(root.val)) return root;

        TreeNode l = helper(root.left, set);
        TreeNode r = helper(root.right, set);

        if (l != null && r != null) return root;
        else return l == null? r : l;
    }

    // private TreeNode helper(TreeNode root, HashSet<Integer> set){
    //     boolean l = find(root.left, set);
    //     boolean r = find(root.right, set);
    //     if (l && r) return root;
    //     if (set.contains(root.val)) return root;
    //     if (l) return helper(root.left, set);
    //     else return helper(root.right, set);
    // }

    // private boolean find(TreeNode root, HashSet<Integer> set){
    //     Stack<TreeNode> stack = new Stack<>();
    //     stack.push(root);

    //     while(!stack.isEmpty()){
    //         TreeNode cur = stack.pop();
    //         if (cur == null) continue;
    //         if (set.contains(cur.val)) return true;
    //         stack.push(cur.left);
    //         stack.push(cur.right);
    //     }

    //     return false;
    // }
}
