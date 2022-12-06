/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode sortLinkedList(ListNode head) {
        Deque<ListNode> stack = new ArrayDeque<>();
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode cur = dummy;
        while(cur != null && cur.next != null){
            if (cur.next.val < 0) {
                stack.push(cur.next);
                cur.next = cur.next.next;
            }else
                cur = cur.next;
        }

        ListNode newHead = stack.isEmpty()? dummy.next : stack.peek();
        while(!stack.isEmpty()) stack.pop().next = stack.isEmpty()? dummy.next : stack.peek();

        return newHead;
    }
}
