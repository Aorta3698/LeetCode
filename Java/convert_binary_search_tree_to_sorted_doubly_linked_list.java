/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/

class Solution {
    public Node treeToDoublyList(Node root) {
        if (root == null) return null;

        Stack<Node> stack = new Stack<>();
        Deque<Node> copy = new LinkedList<>();

        Node cur = root;
        while(!stack.isEmpty() || cur != null){
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }

            cur = stack.pop();
            copy.offer(cur);
            cur = cur.right;
        }

        Node head = copy.peekFirst();
        Node prev = copy.peekLast();
        while(!copy.isEmpty()){
            Node node = copy.poll();
            node.left = prev;
            prev.right = node;
            prev = node;
        }

        return head;
    }
}
