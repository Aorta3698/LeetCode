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

    private Random random;
    private List<Integer> list;
    public Solution(ListNode head) {
        list = new ArrayList<>(List.of(head.val));
        random = new Random();
        while(head.next != null){
            head = head.next;
            list.add(head.val);
        }
    }

    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */
