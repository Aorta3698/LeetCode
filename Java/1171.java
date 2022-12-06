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
    public ListNode removeZeroSumSublists(ListNode head) {
        Map<Integer, ListNode> map = new HashMap<>();
        map.put(0, new ListNode(0, head));
        int pre = 0;
        Set<ListNode> dead = new HashSet<>();

        while(head != null){
            pre += head.val;
            if (map.containsKey(pre) && !dead.contains(map.get(pre))){
                ListNode cur = map.get(pre).next;
                while (cur != null && cur != head.next){
                    dead.add(cur);
                    cur = cur.next;
                }
                map.get(pre).next = head.next;
            }else{
                map.put(pre, head);
            }
            head = head.next;
        }

        return map.get(0).next;
    }
}
