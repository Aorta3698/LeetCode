class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int idx = 0, n = timeSeries.length, ans = 0;
        while(idx < n){
            while (idx < n - 1 && timeSeries[idx] + duration >= timeSeries[idx + 1])
                ans += timeSeries[idx + 1] - timeSeries[idx++];
            ans += duration;
            idx++;
        }

        return ans;
    }
}
