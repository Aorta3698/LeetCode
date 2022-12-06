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
    public ListNode mergeKLists(ListNode[] lists) {
        int sIdx = -1;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < lists.length; i++){
            if (lists[i] == null) continue;
            if (lists[i].val < min){
                min = lists[i].val;
                sIdx = i;
            }
        }

        if (sIdx == -1) return null;

        ListNode head = lists[sIdx];
        for (int i = 0; i < lists.length; i++){
            if (i == sIdx) lists[i] = lists[i].next;
            else lists[i] = lists[i];
        }

        head.next = mergeKLists(lists);
        return head;
    }
}
