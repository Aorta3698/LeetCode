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
    public ListNode addTwoNumbers(ListNode A, ListNode B) {
        int carry = 0;
        ListNode dummyHead = new ListNode();
        ListNode cur = dummyHead;
        while(carry > 0 || A != null || B != null){
            int sum = carry + (A == null? 0 : A.val) + (B == null? 0 : B.val);
            if (A != null){
                A = A.next;
            }
            if (B != null){
                B = B.next;
            }
            carry = sum / 10;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
        }
        return dummyHead.next;
    }
}
