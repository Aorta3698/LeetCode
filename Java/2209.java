class Solution {
    public int minimumWhiteTiles(String floor, int numCarpets, int carpetLen) {
        if (numCarpets*carpetLen>=floor.length()){
            return 0;
        }
        int[][] dp = new int[floor.length()][numCarpets+1];
        for (int i = 0; i < floor.length(); i++){
            for (int j = 0; j <= numCarpets; j++){
                dp[i][j]=Math.min((i==0?0:dp[i-1][j])+floor.charAt(i)-'0',j==0?1000:i<carpetLen?0:dp[i-carpetLen][j-1]);
            }
        }
        return dp[floor.length()-1][numCarpets];
    }
}

// TLE
class Solution {
    public int minimumWhiteTiles(String floor, int numCarpets, int carpetLen) {
        if (numCarpets*carpetLen>=floor.length()){
            return 0;
        }
        int[] dp = new int[floor.length()];
        for (int i = 0; i < floor.length(); i++){
            dp[i]=(i==0?0:dp[i-1])+floor.charAt(i)-'0';
        }
        for (int i = 1; i <= numCarpets; i++){
            for (int j = floor.length()-1; j >= 0; j--){
                for (int k = j,cnt=0; k >= carpetLen; k--){
                    dp[j]=Math.min(dp[k-carpetLen]+cnt,dp[j]);
                    cnt+=floor.charAt(k)-'0';
                }
                if (j<carpetLen){
                    dp[j]=0;
                }
            }
        }

        return dp[floor.length()-1];
    }
}
