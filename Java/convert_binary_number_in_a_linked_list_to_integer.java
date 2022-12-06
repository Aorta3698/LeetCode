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
    public int getDecimalValue(ListNode head) {
        LinkedList<Integer> nums = new LinkedList<>();
        while(head != null){
            nums.addFirst(head.val);
            head = head.next;
        }

        int ans = 0;
        for (int i = 0; i < nums.size(); i++)
            ans += nums.get(i) << i;

        return ans;
    }
}
