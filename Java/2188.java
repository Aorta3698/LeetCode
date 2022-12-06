https://leetcode.com/problems/minimum-time-to-finish-the-race/discuss/2270232/Java-or-DP-or-2-codes-or-O(1)-space
class Solution {
    public int minimumFinishTime(int[][] tires, int changeTime, int numLaps) {
        int[] cost = new int[20];
        int INF = (int)1e9;
        Arrays.fill(cost, INF);
        for (int[] t : tires){
            for (int i = 0,sum=t[0],cur=t[0]; i < 20; i++,cur*=t[1],sum+=cur){
                cost[i] = Math.min(cost[i], sum);
                if (sum+1L*cur*t[1]>= 1e6){
                    break;
                }
            }
        }
        int[] dp = new int[numLaps];
        Arrays.fill(dp, INF);
        for (int i = 0; i < numLaps; i++){
            for (int j = 0; j <= Math.min(i,19); j++){
                dp[i]=Math.min(dp[i], (j==i?0:dp[i-j-1])+cost[j]+changeTime);
            }
        }
        return dp[numLaps-1]-changeTime;
    }
}

class Solution {
    public int minimumFinishTime(int[][] tires, int changeTime, int numLaps) {
        int[] cost = new int[20];
        int INF = (int)1e9;
        Arrays.fill(cost, INF);
        for (int[] t : tires){
            for (int i = 0,sum=t[0],cur=t[0]; i < 20; i++,cur*=t[1],sum+=cur){
                cost[i] = Math.min(cost[i], sum);
                if (sum+1L*cur*t[1]>= 1e6){
                    break;
                }
            }
        }

        int[] dp = new int[20];
        Arrays.fill(dp, INF);
        dp[0]=cost[0];
        for (int i = 1 ; i < numLaps; i++){
            int[] next = new int[20];
            Arrays.fill(next, INF);
            for (int j = 0; j < 20; j++){
                next[0]=Math.min(dp[j]+changeTime+cost[0], next[0]);
                if (j>0){
                    next[j]=dp[j-1]-cost[j-1]+cost[j];
                }
            }
            dp=next;
        }
        return Arrays.stream(dp).min().getAsInt();
    }
}
