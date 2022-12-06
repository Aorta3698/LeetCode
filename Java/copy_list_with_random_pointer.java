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
    HashMap<Node, Node> map = new HashMap<>();
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        
        if (map.containsKey(head))
            return map.get(head);

        Node newHead = new Node(head.val);
        map.put(head, newHead);

        newHead.next = copyRandomList(head.next);
        newHead.random = copyRandomList(head.random);

        return newHead;
        // if (head == null) return null;

        // Node newHead = new Node(head.val);
        // Node cur = newHead;
        // Node old = head;

        // int len = 1;
        // while(old.next != null){
        //     cur.next = new Node(old.next.val);
        //     cur = cur.next;
        //     old = old.next;
        //     len++;
        // }

        // cur = newHead;
        // old = head;

        // while(cur != null){
        //     Node node = old.random;
        //     if (node == null){
        //         cur.random = null;
        //     }else{
        //         int count = 0;
        //         while (node != null){
        //             node = node.next;
        //             count++;
        //         }

        //         Node h = newHead;
        //         for (int i = 0; i < len-count; i++){
        //             h = h.next;
        //         }

        //         cur.random = h;
        //     }
        //     cur = cur.next;
        //     old = old.next;
        // }

        // return newHead;
    }
}
