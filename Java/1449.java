class Solution {
    public String largestNumber(int[] cost, int t) {
        ++t;
        int[] dp = new int[t];
        int[] who = new int[t];
        int[] parent = new int[t];
        Arrays.fill(dp, -1);
        dp[0]=0;
        for (int i = 1; i < t; i++){
            for (int j = 0; j < cost.length; j++){
                if (i-cost[j]>=0){
                    if (dp[i-cost[j]]!=-1&&dp[i-cost[j]]+1>=dp[i]){
                        dp[i]=dp[i-cost[j]]+1;
                        parent[i]=i-cost[j];
                        who[i]=j+1;
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0,cur=t-1; i < dp[t-1]; i++){
            sb.append(who[cur]);
            cur=parent[cur];
        }
        return sb.isEmpty()?"0":sb.toString();
    }
}
