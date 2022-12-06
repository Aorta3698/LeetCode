class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int ans = 0;
        int[] cnt = new int[60];
        for (int t : time){
            ans += cnt[(60 - t % 60) % 60];
            cnt[t % 60]++;
        }

        return ans;
    }
}
