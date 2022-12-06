https://leetcode.com/problems/shortest-impossible-sequence-of-rolls/discuss/2323889/Java-or-one-pass-or-O(n)-at-8ms-or-Explained
class Solution {
    public int shortestSequence(int[] rolls, int k) {
        int ans = 1, ok = 0;
        int[] count = new int[k+1];
        for (int n : rolls){
            if (count[n]+1 == ans && ++ok%k == 0){
                ans++;
            }
            count[n] = Math.min(ans, count[n]+1);
        }
        return ans;
    }
}
