class Solution {
    private final int A = 0;
    private final int E = 1;
    private final int I = 2;
    private final int O = 3;
    private final int U = 4;
    private final int M = (int)1e9+7;

    public int countVowelPermutation(int n) {

        int[][] dp = new int[n][5];
        for (int i = 0; i < 5; i++) dp[0][i] = 1;

        for (int i = 1; i < n; i++){
            int pA = dp[i - 1][A] % M;
            int pE = dp[i - 1][E] % M;
            int pI = dp[i - 1][I] % M;
            int pO = dp[i - 1][O] % M;
            int pU = dp[i - 1][U] % M;

            dp[i][A] = ((pE + pI) % M + pU) % M;
            dp[i][E] = (pA + pI) % M;
            dp[i][I] = (pE + pO) % M;
            dp[i][O] = pI;
            dp[i][U] = (pI + pO) % M;
        }

        int ans = 0;
        for (int i = 0; i < 5; i++)
            ans = (ans + dp[n - 1][i]) % M;

        return ans;
    }
}
