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
    public ListNode plusOne(ListNode head) {
        Deque<ListNode> stack = new ArrayDeque<>();
        while(head != null){
            stack.push(head);
            head = head.next;
        }
        int carry = 1;
        while(!stack.isEmpty()){
            head = stack.pop();
            head.val = (head.val + carry) % 10;
            carry = carry == 1 && head.val == 0? 1 : 0;
        }
        if (head.val == 0 && carry == 1){
            ListNode newHead = new ListNode(1, head);
            return newHead;
        }
        return head;
    }
}
