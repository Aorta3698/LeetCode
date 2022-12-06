https://leetcode.com/problems/minimum-cost-to-connect-two-groups-of-points/discuss/2329362/Java-or-From-Hints-or-Submask
class Solution {
    public int connectTwoGroups(List<List<Integer>> cost) {
        int m = cost.size(), n = cost.get(0).size(), INF = (int)1e9;
        int[] dp = new int[1<<n];
        Arrays.fill(dp, INF);
        dp[0]=0;
        for (int i = 0; i < m; i++){
            int[] ndp = new int[1<<n];
            int[] sum = new int[1<<n];
            int min = INF;
            for (int j = 0; j < n; j++){
                sum[1<<j]=cost.get(i).get(j);
                min = Math.min(sum[1<<j], min);
            }
            for (int j = 0; j < 1<<n; j++){
                sum[j]=sum[j&-j]+sum[j&(j-1)];
            }
            for (int j = 0; j < 1<<n; j++){
                ndp[j]=min+dp[j];
                for (int sub = j-1; sub >= 0; sub=(sub-1)&j){
                    ndp[j]=Math.min(ndp[j], dp[sub]+sum[j^sub]);
                    if (sub == 0){
                        break;
                    }
                }
            }
            dp=ndp;
        }
        return dp[(1<<n)-1];
    }
}

// [1, 3, 5]
// [4, 1, 1]
// [1, 5, 3]
