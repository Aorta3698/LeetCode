class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0, head);
        ListNode st = dummy;
        while(--left>0){
            st=st.next;
            --right;
        }
        ListNode cur = st.next, next = cur.next, tail = cur;
        while(--right>0){
            ListNode prev = cur;
            cur = next;
            next = cur.next;
            cur.next = prev;
        }
        tail.next = next;
        st.next = cur;
        return dummy.next;
    }
}


class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(-1, head);
        ListNode cur = dummy;
        for (int i = 1; i < left; i++){
            cur = cur.next;
        }

        cur.next = reverse(cur.next, 0, right - left, new ArrayDeque<>());

        return dummy.next;
    }

    private ListNode reverse(ListNode head, int t, int o, Deque<ListNode> deque){
        if (head == null || head.next == null || t == o) {
            if (head != null && head.next != null) deque.offer(head.next);
            return head;
        }
        ListNode newHead = reverse(head.next, t + 1, o, deque);
        head.next.next = head;
        head.next = t == 0? deque.poll() : null;
        return newHead;
    }
}
