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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode btail = list2;
        ListNode astart = list1;
        int d = b - a + 3;
        while(btail.next != null) btail = btail.next;
        while(--a > 0) astart = astart.next;
        ListNode aend = astart;
        while(--d > 0) aend = aend.next;
        astart.next = list2;
        btail.next = aend;

        return list1;
    }
}
