https://leetcode.com/problems/cat-and-mouse-ii/discuss/2203880/Java-or-5D-DP-or-Threshold-100
class Solution {
    int[] dx = new int[]{0, 0, 1 ,-1};
    int[] dy = new int[]{-1, 1, 0, 0};
    int m;
    int n;
    int TIME_MAX = 100;
    public boolean canMouseWin(String[] grid, int catJump, int mouseJump) {
        m = grid.length;
        n = grid[0].length();
        int mouseI = 0, mouseJ = 0;
        int catI = 0, catJ = 0;
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                switch(grid[i].charAt(j)){
                    case 'M' -> {mouseI = i; mouseJ = j;}
                    case 'C' -> {catI = i; catJ = j;}
                }
            }
        }
        return dfs(0, mouseI, mouseJ, catI, catJ, catJump, mouseJump, grid, new Boolean[TIME_MAX+1][m][n][m][n]);
    }

    private boolean dfs(int time, int mI, int mJ, int cI, int cJ, int cJump, int mJump, String[] grid, Boolean[][][][][] memo){
        if (grid[mI].charAt(mJ)=='F'){
            return true;
        }
        if (grid[cI].charAt(cJ)=='F' || cI==mI&&cJ==mJ || time > TIME_MAX){
            return false;
        }
        if (memo[time][mI][mJ][cI][cJ]!=null){
            return memo[time][mI][mJ][cI][cJ];
        }
        boolean mT = time % 2 == 0;
        int jump = mT? mJump : cJump;
        int x = mT? mI : cI;
        int y = mT? mJ : cJ;
        if (!mT&&!dfs(time+1,mI,mJ,cI,cJ,cJump,mJump,grid,memo)){
            return memo[time][mI][mJ][cI][cJ]=false;
        }
        for (int i = 0; i < 4; i++){
            for (int j = 1; j <= jump; j++){
                int nx = x + dx[i]*j;
                int ny = y + dy[i]*j;
                if (nx < 0 || ny < 0 || nx == m || ny == n || grid[nx].charAt(ny)=='#'){
                    break;
                }
                boolean res = dfs(time+1, mT? nx : mI, mT? ny : mJ, mT? cI : nx, mT? cJ : ny, cJump, mJump, grid, memo);
                if (mT&&res){
                    return memo[time][mI][mJ][cI][cJ]=true;
                }
                if (!mT&&!res){
                    return memo[time][mI][mJ][cI][cJ]=false;
                }
            }
        }
        return memo[time][mI][mJ][cI][cJ]=!mT;
    }
}
