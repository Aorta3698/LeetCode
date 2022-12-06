/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode A, ListNode B) {
        ListNode curA = A;
        ListNode curB = B;
        while(curA != curB){
            curA = curA == null? B : curA.next;
            curB = curB == null? A : curB.next;
        }
        return curA;
    }
}
