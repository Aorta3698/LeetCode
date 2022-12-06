https://leetcode.com/problems/number-of-spaces-cleaning-robot-cleaned/discuss/1911701/Java-or-Track-visited-cell-w-direction
class Solution {
    public int numberOfCleanRooms(int[][] room) {
        int n = room[0].length, m = room.length, ans = 0;
        int[] x = new int[]{0, 1, 0, -1};
        int[] y = new int[]{1, 0, -1, 0};
        boolean[][][] visited = new boolean[4][m][n];
        int i = 0, j = 0, k = 0;
        while(!visited[k][i][j]){
            if (room[i][j] == 0){
                room[i][j] = -1;
                ans++;
            }
            visited[k][i][j] = true;
            int count = 0;
            while (i + x[k] == m || i + x[k] == -1
                                 || j + y[k] == n
                                 || j + y[k] == -1
                                 || room[i + x[k]][j + y[k]] == 1){
                k = (k + 1) % 4;
                if (++count == 4)
                    return ans;
            }
            i += x[k];
            j += y[k];
        }
        return ans;
    }
}
