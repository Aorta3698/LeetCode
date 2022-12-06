/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }
};
*/

class Solution {
    public Node insert(Node head, int insertVal) {
        Node node = new Node(insertVal);
        if (head == null){
            node.next = node;
            return node;
        }

        Node cur = head;
        Node fast = head.next;

        while(true){
            if (fast.val >= insertVal && insertVal >= cur.val){
                node.next = fast;
                cur.next = node;
                break;
            }else if(fast.val < cur.val){
                if (node.val < fast.val || node.val > cur.val){
                    node.next = fast;
                    cur.next = node;
                    break;
                }
            }else if (fast == head){
                node.next = fast;
                cur.next = node;
                break;
            }
            cur = cur.next;
            fast = fast.next;
        }

        return head;
    }
}
