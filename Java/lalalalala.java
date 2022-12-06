class Solution{
    public int solve(String[][] words, String goal){
        int M = (int)1e9+7;
        long[] dp = new long[goal.length()+1];
        dp[0]=1;
        for (int i = 0; i < words[0].length(); i++){
            int[] count = new int[26];
            for (String s : words){
                count[s.charAt(i)-'a']++;
            }
            for (int j = goal.length(); j >= 1; j--){
                dp[j]+=dp[j-1]*count[goal.charAt(j-1)-'a']%M;
            }
        }
        return (int)dp[goal.length()];
    }
}


class Solution {
    public int solve(char[][] grid){
        int INF = (int)-1e9;
        int[] dp = new int[5];
        for (int i = 0; i < 5; i++){
            dp[i] = switch(grid[0][i]){
                case 'R': yield INF;
                case 'C': yield 1;
                default : yield 0;
            };
        }
        for (int i = 1; i <= grid.length; i++){
            int[] ndp = new int[5];
            for (int j = 0; j < 5; j++){
                int top = dp[j];
                int topLeft = j==0||i<grid.length&&grid[i][j-1]=='R'&&grid[i-1][j]=='R'?INF:dp[j-1];
                int topRight= j==4||i<grid.length&&grid[i][j+1]=='R'&&grid[i-1][j]=='R'?INF:dp[j+1];
                int val = max(topLeft, top, topRight);
                ndp[j]=switch(i==grid.length?'_':grid[i][j]){
                    case 'R' : yield INF;
                    case 'C' : yield 1+val;
                    default  : yield val;
                };
            }
            dp=ndp;
        }
        return dp[2]<0?-1:dp[2];
    }

    private int max(int... arr){
        return Arrays.stream(arr).max().getAsInt();
    }
}
