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
        if (head == null) {
            node.next = node;
            return node;
        }

        Node cur = head;
        Node fast = head;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int count = 0;

        while(true){
            min = Math.min(min, cur.val);
            max = Math.max(max, cur.val);

            if (cur.val <= insertVal && cur.next.val >= insertVal){
                node.next = cur.next;
                cur.next = node;
                return head;
            }

            fast = fast.next.next;
            cur = cur.next;

            if (fast == cur) count++;

            if (count >= 2 && cur.next.val == min && cur.val == max){
                node.next = cur.next;
                cur.next = node;
                return head;
            }
        }
    }
}
