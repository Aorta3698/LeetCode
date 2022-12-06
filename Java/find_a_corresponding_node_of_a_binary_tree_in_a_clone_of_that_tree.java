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
    public final TreeNode getTargetCopy(final TreeNode original,
            final TreeNode cloned, final TreeNode target) {

        Stack<TreeNode> origin = new Stack<>();
        Stack<TreeNode> clone = new Stack<>();
        origin.push(original);
        clone.push(cloned);
        while(!origin.isEmpty()){
            TreeNode o = origin.pop();
            TreeNode c = clone.pop();
            if (o == null) continue;
            if (o == target) return c;

            origin.push(o.right);
            origin.push(o.left);
            clone.push(c.right);
            clone.push(c.left);
        }

        return null;
    }
}
