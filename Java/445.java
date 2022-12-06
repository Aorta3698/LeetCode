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
    public ListNode addTwoNumbers(ListNode A, ListNode B) {
        Deque<Integer> one = new ArrayDeque<>();
        Deque<Integer> two = new ArrayDeque<>();
        while(A != null){
            one.push(A.val);
            A = A.next;
        }
        while(B != null){
            two.push(B.val);
            B = B.next;
        }
        ListNode head = null;
        int carry = 0;
        while(carry > 0 || !one.isEmpty() || !two.isEmpty()){
            int sum = (one.isEmpty()? 0 : one.pop()) + (two.isEmpty()? 0 : two.pop()) + carry;
            ListNode cur = new ListNode(sum % 10);
            carry = sum / 10;
            cur.next = head;
            head = cur;
        }
        return head;
    }
}

https://leetcode.com/problems/add-two-numbers-ii/discuss/1850328/Java-or-O(n)-or-No-Reverse-Recursion-or-86-Speed
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int one = get(l1), two = get(l2);
        if (two > one) {
            return addTwoNumbers(l2, l1);
        }
        for (int i = 0; i < one - two; i++){
            ListNode tmp = new ListNode();
            tmp.next = l2;
            l2 = tmp;
        }

        if (add(l1, l2) == 1){
            ListNode newHead = new ListNode(1);
            newHead.next = l1;
            return newHead;
        }
        return l1;
    }

    private int add(ListNode one, ListNode two){
        if (one == null) return 0;
        int carry = add(one.next, two.next);
        one.val += two.val + carry;
        carry = one.val / 10;
        one.val %= 10;
        return carry;
    }

    private int get(ListNode head){
        ListNode cur = head;
        int ans = 0;
        while(cur != null){
            ans++;
            cur = cur.next;
        }
        return ans;
    }
}
