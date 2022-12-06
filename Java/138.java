/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();
        Node dummy = new Node(0), cur = dummy, p = head;
        while(p != null){
            Node node = new Node(p.val);
            cur.next = node;
            cur = cur.next;
            map.put(p, node);
            p = p.next;
        }
        p = head;
        cur = dummy.next;
        while(p != null){
            cur.random = map.get(p.random);
            p = p.next;
            cur = cur.next;
        }
        return dummy.next;
    }
}
