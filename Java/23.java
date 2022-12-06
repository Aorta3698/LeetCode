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
        PriorityQueue<ListNode> minheap = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
        for (ListNode l : lists){
            if (l != null){
                minheap.offer(l);
            }
        }
        ListNode dummy = new ListNode(), cur = dummy;
        while(!minheap.isEmpty()){
            cur.next = minheap.poll();
            cur = cur.next;
            if (cur.next != null){
                minheap.offer(cur.next);
            }
        }
        return dummy.next;
    }
}
