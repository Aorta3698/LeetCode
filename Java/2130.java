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
    public int pairSum(ListNode head) {
        ListNode slow = head, fast = head;
        Deque<Integer> stack = new ArrayDeque<>();
        while(fast != null && fast.next != null){
            stack.push(slow.val);
            slow = slow.next;
            fast = fast.next.next;
        }

        int ans = 0;
        while(!stack.isEmpty()){
            ans = Math.max(stack.pop() + slow.val, ans);
            slow = slow.next;
        }

        return ans;
    }
}
