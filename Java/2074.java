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
    public ListNode reverseEvenLengthGroups(ListNode head) {
        ListNode cur = head, tmp = cur;
        Deque<ListNode> d = new ArrayDeque<>();
        int need = 1, step = 0;
        int[] count = new int[]{1};

        while(cur != null){
            if (++step < 2 * need - 1){
                cur = cur.next;
                continue;
            }
            tmp = cur.next;
            cur.next = reverse(cur.next, count, 2 * need, d);
            if (count[0] % 2 == 1){
                count[0] = 0;
                cur.next = reverse(cur.next, count, 2 * need, d);
                return head;
            }
            cur = tmp == null? null : tmp.next;
            count[0] = 1;
            step = 0;
            need++;
        }
        if (step % 2 == 0 && tmp != null){
            tmp.next = reverse(tmp.next, count, step, d);
        }

        return head;
    }

    private ListNode reverse(ListNode head, int[] start, int end, Deque<ListNode> deque){
        if (head == null || head.next == null) return head;
        if (start[0] == end){
            deque.offer(head.next);
            return head;
        }

        boolean first = start[0]++ == 1;
        ListNode last = reverse(head.next, start, end, deque);
        head.next.next = head;
        head.next = first? deque.poll() : null;

        return last;
    }
}
