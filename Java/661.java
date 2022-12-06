class Solution {
    public int[][] imageSmoother(int[][] img) {
        int r = img.length, c = img[0].length;
        int[][] ans = new int[r][c];

        for (int i = 0; i < r; i++){
            for (int j = 0, cnt = 0, sum = 0; j < c; ans[i][j] = sum / cnt, sum = cnt = 0, j++){
                for (int w = 0; w < 3; w++){
                    for (int e = 0; e < 3; e++){
                        int x = i + w - 1;
                        int y = j + e - 1;
                        if (x < 0 || x >= r || y < 0 || y >= c) continue;
                        sum += img[x][y];
                        cnt++;
                    }
                }
            }
        }

        return ans;
    }
}
