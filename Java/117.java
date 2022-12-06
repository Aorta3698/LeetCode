/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    Node parent; // can't just pass it in as the argument. won't get updated.
    public Node connect(Node root) {
        parent = root;
        while(true){
            Node start = nextNode(null);
            Node cur = start;
            while(cur != null){
                cur.next = nextNode(cur);
                cur = cur.next;
            }
            if (start == null)
                return root;
            parent = start;
        }
    }

    private Node nextNode(Node cur){
        while(parent != null){
            if (parent.left != null && parent.left != cur)
                return parent.left;
            if (parent.right != null && parent.right != cur){
                Node ans = parent.right;
                parent = parent.next;
                return ans;
            }
            parent = parent.next;
        }
        return null;
    }
}
