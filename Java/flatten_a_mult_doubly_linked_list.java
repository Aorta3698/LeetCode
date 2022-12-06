/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        if (head == null) return head;
        Node dummy = new Node();
        dummy.next = head;
        Node cur = dummy;
        Stack<Node> stack = new Stack<>();

        while(cur.next != null){
            if (cur.next.child != null){
                if (cur.next.next != null)
                    stack.push(cur.next.next);
                cur.next.child.prev = cur.next;
                cur.next.next = cur.next.child;
                cur.next.child = null;
            }else
                cur = cur.next;
        }

        while(!stack.isEmpty()){
            Node n = stack.pop();
            cur.next = n;
            n.prev = cur;
            while(cur.next != null) cur = cur.next;
        }

        return dummy.next;

        // Similarly, this would work fine too but you have to do
        // one more check in the while loop.
        //
        // Node cur = head;
        // Stack<Node> stack = new Stack<>();

        // while(cur.next != null || cur.child != null){
        //     if (cur.child != null){
        //         if (cur.next != null)
        //             stack.push(cur.next);
        //         cur.child.prev = cur;
        //         cur.next = cur.child;
        //         cur.child = null;
        //     }else
        //         cur = cur.next;
        // }

        // while(!stack.isEmpty()){
        //     Node n = stack.pop();
        //     cur.next = n;
        //     n.prev = cur;
        //     while(cur.next != null) cur = cur.next;
        // }

        // return head;
    }
}
