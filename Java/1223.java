class Solution {
    public int dieSimulator(int n, int[] rollMax) {
        int M = (int)1e9+7;
        int[][] dp = new int[6][16];
        for (int j=0;j<6;j++){
            dp[j][0]=1;
        }
        for (int i =0;i<n;i++){
            int[][] next = new int[6][16];
            for (int j=0;j<6;j++){
                for (int k=0;k<6;k++){
                    for (int v=1;v<16;v++){
                        if(j==k&&v<=rollMax[j]){
                            next[j][v]+=dp[k][v-1];
                            next[j][v]%=M;
                        }
                        if (j!=k){
                            next[j][1]+=dp[k][v];
                            next[j][1]%=M;
                        }
                    }
                }
            }
            dp=next;
        }

        int ans =0;
        for (int i = 0; i<6;i++){
            for (int j=1;j<16;j++){
                ans+=dp[i][j];
                ans%=M;
            }
        }
        return ans;
    }
}
