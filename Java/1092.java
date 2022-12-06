class Solution {
    public String shortestCommonSupersequence(String a, String b) {
        int[][] dp = new int[a.length()+1][b.length()+1];
        for (int i = 1 ; i <= a.length(); i++){
            for (int j = 1; j <= b.length(); j++){
                dp[i][j]=a.charAt(i-1)==b.charAt(j-1)?
                    1+dp[i-1][j-1]:Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        int i = a.length(), j = b.length();
        StringBuilder sb = new StringBuilder();
        while(i>0||j>0){
            if (i>0&&j>0&&a.charAt(i-1)==b.charAt(j-1)&&dp[i][j]==dp[i-1][j-1]+1){
                sb.append(a.charAt(i-1));
                i--; j--;
            }else if (j<0||i>0&&dp[i][j]==dp[i-1][j]){
                sb.append(a.charAt(i-1));
                i--;
            }else if (i<0||j>0&&dp[i][j]==dp[i][j-1]){
                sb.append(b.charAt(j-1));
                j--;
            }
        }
        return sb.reverse().toString();
    }
}
