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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root.val == p.val || root.val == q.val) return root;

        TreeNode lNode = lowestCommonAncestor(root.left, p, q);
        TreeNode rNode = lowestCommonAncestor(root.right, p, q);

        if (lNode != null && rNode != null) return root;
        else if (lNode != null) return lNode;
        else return rNode;
        // if (root.val == p.val || root.val == q.val) return root;
        // if (find(root.right, p, q) && find(root.left, p, q))
        //     return root;
        // if (find(root.right, p, q))
        //     return lowestCommonAncestor(root.right, p, q);
        // else
        //     return lowestCommonAncestor(root.left, p, q);
    }

    // private boolean find(TreeNode root, TreeNode p, TreeNode q){
    //     Stack<TreeNode> stack = new Stack<>();
    //     stack.push(root);

    //     while(!stack.isEmpty()){
    //         TreeNode cur = stack.pop();
    //         if (cur == null) continue;
    //         else if (cur.val == p.val || cur.val == q.val)
    //             return true;

    //         stack.push(cur.left);
    //         stack.push(cur.right);
    //     }

    //     return false;
    // }
}
