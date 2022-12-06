class Solution {
    public int shortestDistance(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int id = 0;
        int[][] count = new int[m][n];
        int[][] ttl = new int[m][n];
        int[][] seen = new int[m][n];
        int[] dx = new int[]{0,0,-1,1};
        int[] dy = new int[]{1,-1,0,0};
        for (int i = 0;i<m;i++){
            for (int j=0;j<n;j++){
                if (grid[i][j]==1){
                    Queue<int[]> queue = new ArrayDeque<>();
                    int dist = 0;
                    seen[i][j]=++id;
                    queue.offer(new int[]{i, j});
                    while(!queue.isEmpty()){
                        for (int sz = queue.size(); sz>0;--sz){
                            int[] top =queue.poll();
                            int x=top[0];
                            int y=top[1];
                            ttl[x][y]+=dist;
                            count[x][y]++;
                            for (int k =0;k<4;k++){
                                int nx=x+dx[k];
                                int ny=y+dy[k];
                                if (nx<0||ny<0||nx==m||ny==n||grid[nx][ny]==2||seen[nx][ny]==id||grid[nx][ny]==1){
                                    continue;
                                }
                                queue.offer(new int[]{nx, ny});
                                seen[nx][ny]=id;
                            }
                        }
                        dist++;
                    }
                }
            }
        }
        int ans = (int)1e9;
        for (int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(count[i][j]==id&&ans>ttl[i][j]&&grid[i][j]==0){
                    ans=ttl[i][j];
                }
            }
        }
        return ans==(int)1e9?-1:ans;
    }
}
