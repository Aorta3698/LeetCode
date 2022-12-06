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
        if (head == null)
            return null;
        ListNode evenHead = head.next, oddCur = head, evenCur = evenHead;
        while(evenCur != null && evenCur.next != null){
            oddCur.next = oddCur.next.next;
            evenCur.next = evenCur.next.next;
            oddCur = oddCur.next;
            evenCur = evenCur.next;
        }
        oddCur.next = evenHead;
        return head;
    }
}
