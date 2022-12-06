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
    public int[] nextLargerNodes(ListNode head) {
        int sz = 0;
        ListNode cur = head;
        while (cur != null){
            cur = cur.next;
            sz++;
        }
        int[] ans = new int[sz];
        Deque<int[]> stack = new ArrayDeque<>();
        cur = head;
        int idx = 0;
        while(cur != null){
            while(!stack.isEmpty() && cur.val > stack.peek()[0]){
                ans[stack.poll()[1]] = cur.val;
            }
            stack.push(new int[]{cur.val, idx++});
            cur = cur.next;
        }
        return ans;
    }
}
