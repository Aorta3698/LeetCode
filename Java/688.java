https://leetcode.com/problems/knight-probability-in-chessboard/discuss/1895368/java-2d-dp
class Solution {
    public double knightProbability(int n, int m, int row, int column) {
        //dp[x][y][k] = dp[x+2][y+1][k - 1] * 1/8;
        double[][] dp = new double[n][n];
        for (int i = 0; i <= m; i++){
            double[][] next = new double[n][n];
            for (int j = 0; j < n; j++){
                for (int k = 0; k < n; k++){
                    if (i == 0){
                        next[j][k] = 1;
                        continue;
                    }
                    for (int x = -2; x <= 2; x++){
                        for (int y = 3 - Math.abs(x), w = 0; w < 2 && x != 0; y*=-1, w++){
                            int a = j + x;
                            int b = k + y;
                            if (a < 0 || a >= n || b < 0 || b >= n){
                                continue;
                            }
                            next[j][k] += 0.125 * dp[a][b];
                        }
                    }
                }
            }
            dp = next;
        }

        return dp[row][column];
    }
}

//class Solution {
//    public double knightProbability(int n, int m, int row, int column) {
//        //dp[x][y][k] = dp[x+2][y+1][k - 1] * 1/8;
//        double[][][] dp = new double[n][n][m+1];
//        for (int i = 0; i <= m; i++){
//            for (int j = 0; j < n; j++){
//                for (int k = 0; k < n; k++){
//                    if (i == 0){
//                        dp[j][k][i] = 1;
//                        continue;
//                    }
//                    for (int x = -2; x <= 2; x++){
//                        for (int y = 3 - Math.abs(x), w = 0; w < 2 && x != 0; y*=-1, w++){
//                            int a = j + x;
//                            int b = k + y;
//                            if (a < 0 || a >= n || b < 0 || b >= n){
//                                continue;
//                            }
//                            dp[j][k][i] += 0.125 * dp[a][b][i - 1];
//                        }
//                    }
//                }
//            }
//        }

//        return dp[row][column][m];
//    }
//}
