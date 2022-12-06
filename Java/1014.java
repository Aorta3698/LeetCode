https://leetcode.com/problems/best-sightseeing-pair/discuss/1892652/Java-or-4-Lines-or-O(1)-Space
class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int ans = 0, max = 0;
        for (int n : values){
            ans = Math.max(--max + n, ans);
            max = Math.max(max, n);
        }

        return ans;
    }
}
