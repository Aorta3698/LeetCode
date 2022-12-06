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
https://leetcode.com/problems/reorder-list/discuss/1640460/Java-Clean-ArrayDeque-Solution-w-Comments
class Solution {
    public void reorderList(ListNode head) {
        ListNode slow = head, fast = head;
        Deque<ListNode> stack = new ArrayDeque<>();
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        while(slow != null){
            stack.push(slow);
            slow = slow.next;
        }

        for (slow = head; slow.next != null && !stack.isEmpty(); slow = slow.next.next){
            ListNode tmp = slow.next;
            slow.next = stack.pop();
            slow.next.next = tmp;
        }

        slow.next = null;
    }
}
