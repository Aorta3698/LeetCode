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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int[] ans = new int[]{Integer.MAX_VALUE, 0};
        int prevIdx = -1, curIdx = 0, prev = head.val, first = -1;
        head = head.next;

        while(head.next != null){
            if (prev < head.val && head.val > head.next.val ||
                prev > head.val && head.val < head.next.val){

                if (prevIdx > -1){
                    ans[0] = Math.min(curIdx - prevIdx, ans[0]);
                }else{
                    first = curIdx;
                }
                prevIdx = curIdx;
            }
            prev = head.val;
            head = head.next;
            curIdx++;
        }

        ans[1] = prevIdx - first;
        if (ans[0] == Integer.MAX_VALUE){
            ans[0] = ans[1] = -1;
        }

        return ans;
    }
}
