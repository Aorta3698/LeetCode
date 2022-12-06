
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
        // Stack<TreeNode> stack = new Stack<>();
        // stack.push(root);
        // boolean pFound = false;
        // boolean qFound = false;

        // while(!stack.isEmpty()){
        //     TreeNode cur = stack.pop();
        //     if (cur == null) continue;
        //     if (cur.val == p.val) pFound = true;
        //     if (cur.val == q.val) qFound = true;

        //     stack.push(cur.left);
        //     stack.push(cur.right);
        // }

        // if (!qFound || !pFound) return null;
        AtomicInteger i = new AtomicInteger(0);
        TreeNode result = find(root, p, q, i);
        return i.get() == 2? result : null;
    }

    private TreeNode find(TreeNode root, TreeNode p, TreeNode q, AtomicInteger i){
        if (root == null) return null;

        TreeNode lNode = find(root.left, p, q, i);
        TreeNode rNode = find(root.right, p, q, i);

        if (root.val == p.val || root.val == q.val){
            i.incrementAndGet();
            return root;
        }

        if (lNode != null && rNode != null) return root;
        else if (lNode != null) return lNode;
        else return rNode;
    }
}
