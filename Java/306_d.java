class Solution {
    public int countSpecialNumbers(int n) {
        String s = ""+n;
        int ans = 0;
        int[][][] dp = new int[s.length()+1][1<<10][2];
        dp[s.length()][0][0]=1;
        for (int i = s.length()-1; i >= 0; i--){
            for (int j = 9; j >= 0; j--){
                for (int m = 0; m < 1<<10; m++){
                    for (int t = 0; t < 2 && (m & 1 << j)==0; t++){
                        int nt = t;
                        if (j > s.charAt(i)-'0'){
                            nt=1;
                        }else if (j < s.charAt(i)-'0'){
                            nt=0;
                        }
                        dp[i][m|1<<j][nt] += dp[i+1][m][t];
                    }
                }
                if (j == 1) for (int a = 0; a < 1<<10; a++){
                    ans += dp[i][a][0];
                    if (i>0){
                        ans += dp[i][a][1];
                    }
                }
            }
        }
        return ans;
    }
}
