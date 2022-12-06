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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
https://leetcode.com/problems/linked-list-in-binary-tree/discuss/1779355/Java-or-2-Solutions.
class Solution {
    public boolean isSubPath(ListNode head, TreeNode root) {
        return find(root, head, head, true);
        // int len = 0, prime = 31, mod = (int)1e9 + 9;
        // long h = 1, target = 0;
        // while(head != null){
        //     len++;
        //     target = (target * prime + head.val) % mod;
        //     head = head.next;
        // }
        // for (int i = 0; i < len - 1; i++){
        //     h *= prime;
        //     h %= mod;
        // }
        // return find(root, new ArrayList<>(), target, 0, len, prime, mod, h);
    }

    // private boolean find(TreeNode root, List<Integer> list, long target, long cur, int len, int prime, int mod, long h){
    //     if (root == null) return false;
    //     list.add(root.val);
    //     int n = list.size();

    //     if (n >= len){
    //         if (n > len) cur = (cur - h * list.get(n - len - 1)) % mod;
    //         cur = ((cur * prime + root.val) % mod + mod) % mod;
    //         if (cur == target) return true;
    //     }else{
    //         cur = (cur * prime + root.val) % mod;
    //     }
    //     if (find(root.right, list, target, cur, len, prime, mod, h)) return true;
    //     if (find(root.left , list, target, cur, len, prime, mod, h)) return true;
    //     list.remove(n - 1);
    //     return false;
    // }

    private boolean find(TreeNode root, ListNode cur, ListNode head, boolean s){
        if (cur  == null) return true;
        if (root == null) return false;
        ListNode next = cur.val == root.val? cur.next : new ListNode(-1);
        if (find(root.right, next, head, s)) return true;
        if (find(root.left , next, head, s)) return true;
        if (!s || head.val != root.val) return false;
        if (find(root.right, head.next, head, false)) return true;
        if (find(root.left , head.next, head, false)) return true;
        return false;
    }
}
