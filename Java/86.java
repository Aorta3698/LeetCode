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
    public ListNode partition(ListNode head, int x) {
        ListNode dummyL = new ListNode(), a = dummyL;
        ListNode dummyM = new ListNode(), b = dummyM;
        while(head != null){
            if (head.val < x){
                a.next=head;
                a=head;
            }else{
                b.next=head;
                b=head;
            }
            head=head.next;
        }
        a.next=dummyM.next;
        b.next=null;
        return dummyL.next;
    }
}



class Solution {
    public ListNode partition(ListNode head, int x) {
        Queue<Integer> queue = new ArrayDeque<>();
        ListNode cur = head, idx = head;
        while(cur != null){
            if (cur.val < x){
                idx.val = cur.val;
                idx = idx.next;
            }else{
                queue.offer(cur.val);
            }
            cur = cur.next;
        }
        while(idx != null){
            idx.val = queue.poll();
            idx = idx.next;
        }
        return head;
    }
}

class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode less = new ListNode(x - 1);
        ListNode more = new ListNode(x + 1);
        ListNode ldummy = less;
        ListNode mdummy = more;

        while(head != null){
            if (head.val < x) {
                less.next = head;
                less = head;
            }else{
                more.next = head;
                more = head;
            }
            head = head.next;
        }

        more.next = null;
        less.next = mdummy.next;

        return ldummy.next;
    }
}
