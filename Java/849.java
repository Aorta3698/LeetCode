https://leetcode.com/problems/maximize-distance-to-closest-person/discuss/1693854/Java-One-Pass-and-Concise.-Brief-Explanation.
class Solution {
    public int maxDistToClosest(int[] seats) {
        int ans = 0, prev = 0, cur = -1, idx = 0;
        for (int n : seats){
            if (n == 1){
                prev = cur;
                cur = idx;
                ans = prev == -1? cur : Math.max((cur - prev) / 2, ans);
            }
            idx++;
        }

        return Math.max(seats.length - cur - 1, ans);
    }
}
