https://leetcode.com/problems/minimum-skips-to-arrive-at-meeting-on-time/discuss/2269919/Java-or-Don't-use-Double-Explained-or-Bottom-up-1D-short-DP
class Solution {
    public int minSkips(int[] dist, int speed, int hoursBefore) {
        int N = dist.length, INF = (int)1e9;
        int[] dp = new int[N];
        Arrays.fill(dp, INF);
        dp[0]=0; // before we start, we have a time of 0 for 0 cost
        for (int i = 0 ; i<N; i++){
            for (int j = i; j >= 0; j--){ // j (cost) is at most i (num of element-1) so we start from there.
                dp[j]=Math.min(j==0?INF:dp[j-1]+dist[i], ceil(dp[j], speed)+dist[i]);
            }
        }
        for (int i = 0; i < N; i++){ // find the min cost (i) such that the min time is no greater than hoursBefore
            if (ceil(dp[i],speed)/speed<=hoursBefore){
                return i;
            }
        }
        return -1;
    }

    private int ceil(int n, int s){
        return n+(s-n%s)%s;
    }
}
