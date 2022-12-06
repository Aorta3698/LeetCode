class Solution {
    public int tallestBillboard(int[] rods) {
        int B = 5000, INF = (int)-1e9;
        int[] dp = new int[10001];
        Arrays.fill(dp, INF);
        dp[B]=0;
        for (int i = 0; i < rods.length; i++){
            int[] ndp = new int[dp.length];
            Arrays.fill(ndp, INF);
            for (int j = 0; j <= 10000; j++){
                ndp[j]=Math.max(ndp[j], dp[j]); // do nothing
                if (j+rods[i]<= 10000){
                    ndp[j+rods[i]]=Math.max(ndp[j+rods[i]], dp[j]+rods[i]);
                }
                if (j-rods[i]>=0){
                    ndp[j-rods[i]]=Math.max(ndp[j-rods[i]], dp[j]);
                }
            }
            dp=ndp;
        }
        return dp[B]==INF?0:dp[B];
    }
}
