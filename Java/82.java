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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0, head), cur = dummy;
        while(cur != null && cur.next != null){
            ListNode node = cur.next.next;
            boolean dup = false;
            while (node != null && cur.next.val == node.val){
                node = node.next;
                dup = true;
            }
            if (dup){
                cur.next = node;
            }else{
                cur = cur.next;
            }
        }
        return dummy.next;
    }
}

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        int[] val = new int[201];
        ListNode cur = head, dummy = new ListNode();
        while(cur != null){
            val[cur.val + 100]++;
            cur = cur.next;
        }

        cur = dummy;
        for (int i = 0; i <= 200; i++){
            if (val[i] == 1){
                ListNode node = new ListNode(i - 100);
                cur.next = node;
                cur = cur.next;
            }
        }

        return dummy.next;
    }
}
