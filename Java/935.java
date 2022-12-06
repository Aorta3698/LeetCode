class Solution {
    public int knightDialer(int n) {
        int ans = 0, m = (int)1e9 + 7;
        int[][] dp = new int[4][3];
        for (int[] d : dp){
            Arrays.fill(d, 1);
        }
        dp[3][0] = dp[3][2] = 0;

        for (int k = 1; k < n; k++){
            int[][] next = new int[4][3];
            for (int i = 0; i < 4; i++){
                for (int j = 0; j < 3; j++){
                    for (int a = -2; a <= 2 && ok(i, j); a++){
                        for (int b = 3 - Math.abs(a), c = 0; c < 2 && a != 0; c++, b = -b){
                            if (ok(i + a, j + b)){
                                next[i][j] = (next[i][j] + dp[i + a][j + b]) % m;
                            }
                        }
                    }
                }
            }
            dp = next;
        }

        for (int[] d : dp){
            for (int dd : d){
                ans = (ans + dd) % m;
            }
        }

        return ans;
    }

    private boolean ok(int i, int j){
        return (i >= 0 && i <= 2 && j >= 0 && j <= 2) || (i == 3 && j == 1);
    }
}
