https://leetcode.com/problems/maximize-grid-happiness/discuss/2334764/Java-or-Concise-Bottom-Up-DP-or-Fully-Comments
class Solution {
    int M, INF = (int)-1e9;
    final int TOP = 0, BACK = 1, IN = 1, EX = 2;
    public int getMaxGridHappiness(int m, int n, int I, int E) {
        M = (int)Math.pow(3, n);
        int[][][][] dp = new int[m*n+1][I+1][E+1][M];
        for (int i = 0; i <= m*n; i++){
            for (int a = 0; a <= I; a++){
                for (int b = 0; b <= E; b++){
                    for (int c = 0; c < M; c++){
                        dp[i][a][b][c]=INF;
                    }
                }
            }
        }
        dp[0][I][E][0]=0;
        for (int i = 0; i < m*n; i++){
            for (int a = 0; a <= I; a++){
                for (int b = 0; b <= E; b++){
                    for (int c = 0; c < M; c++){
                        int mask = 3*c%M, val = dp[i][a][b][c], rr = i/n, cc = i%n;
                        int ii = hit(c, rr, cc, TOP, IN) + hit(c, rr, cc, BACK, IN);
                        int ee = hit(c, rr, cc, TOP, EX) + hit(c, rr, cc, BACK, EX);
                        dp[i+1][a][b][mask]=Math.max(dp[i+1][a][b][mask], val); // skip
                        if (a > 0){
                            int gain = 120 - ii*60 - ee*10;
                            dp[i+1][a-1][b][mask+1]=Math.max(dp[i+1][a-1][b][mask+1], val+gain);
                        }
                        if (b > 0){
                            int gain = 40 - ii*10 + ee*40;
                            dp[i+1][a][b-1][mask+2]=Math.max(dp[i+1][a][b-1][mask+2], val+gain);
                        }
                    }
                }
            }
        }
        int ans = 0;
        for (int i = 0; i <= I; i++){
            for (int j = 0; j <= E; j++){
                for (int k = 0; k < M; k++){
                    ans = Math.max(ans, dp[m*n][i][j][k]);
                }
            }
        }
        return ans;
    }

    private int hit(int mask, int i, int j, int o, int t){
        return switch(o){
            case BACK: yield j>0 && mask%3 == t? 1 : 0;
            default  : yield i>0 && mask/(M/3) == t? 1 : 0;
        };
    }
}
