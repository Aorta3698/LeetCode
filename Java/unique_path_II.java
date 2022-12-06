class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] == 1) return 0;
        else obstacleGrid[0][0] = 1;

        int r = obstacleGrid.length;
        int c = obstacleGrid[0].length;

        boolean dead = false;
        for (int i = 1; i < r; i++){
            if (obstacleGrid[i][0] == 1 || dead){
                dead = true;
                obstacleGrid[i][0] = 0;
            }else
                obstacleGrid[i][0] = 1;
        }

        dead = false;
        for (int i = 1; i < c; i++){
            if (obstacleGrid[0][i] == 1 || dead){
                dead = true;
                obstacleGrid[0][i] = 0;
            }else
                obstacleGrid[0][i] = 1;
        }

        for (int i = 1; i < r; i++)
            for (int j = 1; j < c; j++){
                obstacleGrid[i][j] = obstacleGrid[i][j] == 1? 0 : 1;
            }

        for (int i = 1; i < r; i++){
            for (int j = 1; j < c; j++){
                if (obstacleGrid[i][j] == 0) continue;
                obstacleGrid[i][j] = obstacleGrid[i-1][j] + obstacleGrid[i][j-1];
            }
        }

        return obstacleGrid[r-1][c-1];
    }
}
