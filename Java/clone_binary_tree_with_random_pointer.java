/**
 * Definition for Node.
 * public class Node {
 *     int val;
 *     Node left;
 *     Node right;
 *     Node random;
 *     Node() {}
 *     Node(int val) { this.val = val; }
 *     Node(int val, Node left, Node right, Node random) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *         this.random = random;
 *     }
 * }
 */

class Solution {
    HashMap<Node, NodeCopy> seen = new HashMap<>();
    public NodeCopy copyRandomBinaryTree(Node root) {
        if (root == null) return null;
        if (seen.containsKey(root)) return seen.get(root);

        NodeCopy copy = new NodeCopy(root.val);
        seen.put(root, copy);

        copy.right = copyRandomBinaryTree(root.right);
        copy.left = copyRandomBinaryTree(root.left);
        copy.random = copyRandomBinaryTree(root.random);

        return copy;
    }
}
