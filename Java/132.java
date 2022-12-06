class Solution {
    public int minCut(String s) {
        int n = s.length();
        int[] dp = new int[n];
        Arrays.fill(dp, 2000);
        boolean[][] ok = new boolean[n][n];
        for (int i = n-1; i >= 0; --i){
            for (int j = i; j < n; j++){
                ok[i][j]|= i==j||s.charAt(i)==s.charAt(j) && (j-i==1||ok[i+1][j-1]);
                if (ok[i][j]){
                    dp[i]=Math.min(dp[i],j==n-1?0:dp[j+1]+1);
                }
            }
        }
        return dp[0];
    }
}


// 2 Passes solution
class Solution {
    public int minCut(String s) {
        int n = s.length(), ans = 0;
        boolean[][] ok = new boolean[n][n];
        for (int i = n-1; i >= 0; --i){
            for (int j = i; j < n; j++){
                ok[i][j]|= i == j || s.charAt(i)==s.charAt(j) && (j-i==1||ok[i+1][j-1]);
            }
        }
        int[] dp = new int[n];
        Arrays.fill(dp, 2000);
        for (int i = 0; i<n; i++){
            if (ok[0][i]){
                dp[i]=0;
                continue;
            }
            for (int j = i; j>0; --j){
                if (ok[j][i]){
                    dp[i]=Math.min(dp[i], dp[j-1]+1);
                }
            }
        }
        return dp[n-1];
    }
}
