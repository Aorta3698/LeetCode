https://leetcode.com/problems/optimal-account-balancing/discuss/2274757/Java-or-Idea-from-%40yuxiong-post
class Solution {
    public int minTransfers(int[][] transactions) {
        int skip=0, N = 0;
        int[] arr = new int[12];
        for (int[] t : transactions){
            arr[t[0]]-=t[2];
            arr[t[1]]+=t[2];
            N=Math.max(N,Math.max(t[0],t[1])+1);
        }
        int[] dp = new int[1<<N];
        int[] sum = new int[1<<N];
        for (int i = 0; i < N; i++){
            sum[1<<i]=arr[i];
            if (arr[i]==0){
                skip|=1<<i;
            }
        }
        for (int i = 1; i < 1<<N; i++){
            sum[i]=sum[i&-i]+sum[i&(i-1)];
            if ((i&skip)==0&&sum[i]==0){
                dp[i]=1;
                for (int j = i; j>0;j=(j-1)&i){
                    if (sum[j]==0&&sum[i^j]==0){
                        dp[i]=Math.max(dp[i], dp[j]+dp[i^j]);
                    }
                }
            }
        }
        return N - Integer.bitCount(skip) - dp[((1<<N)-1)^skip];
    }
}
