
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
https://leetcode.com/problems/spiral-matrix-iv/discuss/2230252/Java-or-Spiral-or-Go-then-Check
class Solution {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] ans = new int[m][n];
        for (int[] a : ans){
            Arrays.fill(a, -1);
        }
        int[][] dir = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int d = 0;
        int i = 0;
        int j = 0;
        while(head!=null){
            ans[i][j]=head.val;
            int x = i + dir[d][0];
            int y = j + dir[d][1];
            if (x < 0 || y < 0 || x == m || y == n || ans[x][y]!=-1){
                d = (d+1)%4;
            }
            i = i + dir[d][0];
            j = j + dir[d][1];
            head=head.next;
        }
        return ans;
    }
}
