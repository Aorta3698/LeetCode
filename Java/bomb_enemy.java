class Solution {
    public int maxKilledEnemies(char[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        for (int i = 0; i < dp.length; i++){
            for (int j = 0; j < dp[0].length; j++){
                if (grid[i][j] == 'E'){
                    for (int a = i + 1; a < dp.length; a++){
                        if (grid[a][j] == '0') dp[a][j]++;
                        if (dp[a][j] == dp.length + dp[0].length - 1) return dp[a][j];
                        if (grid[a][j] == 'W') break;
                    }
                    for (int a = i - 1; a >= 0; a--){
                        if (grid[a][j] == '0') dp[a][j]++;
                        if (dp[a][j] == dp.length + dp[0].length - 1) return dp[a][j];
                        if (grid[a][j] == 'W') break;
                    }
                    for (int a = j + 1; a < dp[0].length; a++){
                        if (grid[i][a] == '0') dp[i][a]++;
                        if (dp[i][a] == dp.length + dp[0].length - 1) return dp[i][a];
                        if (grid[i][a] == 'W') break;
                    }
                    for (int a = j - 1; a >= 0; a--){
                        if (grid[i][a] == '0') dp[i][a]++;
                        if (dp[i][a] == dp.length + dp[0].length - 1) return dp[i][a];
                        if (grid[i][a] == 'W') break;
                    }
                }
            }
        }

        int max = 0;
        for (int[] d : dp)
            for (int e : d)
                max = Math.max(max, e);

        return max;
    }
}
