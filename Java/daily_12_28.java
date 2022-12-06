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
    public Node connect(Node root) {
        if (root == null) return null;
        Queue<Node> queue = new ArrayDeque<>(List.of(root));
        while(!queue.isEmpty()){
            int sz = queue.size();
            while(--sz >= 0){
                Node cur = queue.poll();
                if (sz > 0) cur.next = queue.peek();
                if (cur.left  != null) queue.offer(cur.left);
                if (cur.right != null) queue.offer(cur.right);
            }
        }

        return root;
    }
}
