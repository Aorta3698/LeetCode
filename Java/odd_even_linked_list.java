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
    public ListNode oddEvenList(ListNode head) {
        if (head == null) return head;
        ListNode evenHead = head.next;
        ListNode cur = head;
        ListNode oddEnd = cur;
        boolean isOdd = false;
        while(cur.next != null){
            ListNode tmp = cur.next;
            cur.next = cur.next.next;
            cur = tmp;
            if (isOdd) oddEnd = cur;
            isOdd = !isOdd;
        }
        oddEnd.next = evenHead;
        return head;
    }
}
