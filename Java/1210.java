class Solution {
    //   3
    // 2   0
    //   1
    public int minimumMoves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][][] seen = new boolean[m][n][4];
        seen[0][1][0]=true;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{0, 1, 2});
        int ans = 0;
        while(!queue.isEmpty()){
            for (int sz = queue.size(); sz > 0; sz--){
                int[] top = queue.poll();
                int x = top[0];
                int y = top[1];
                int t = top[2]; // where tail is relative to head, see the graph above
                if (x==m-1&&y==n-1&&t==2||x==m-1&&y==n-2&&t==0){
                    return ans;
                }
                if (t%2==0&&y<n-1&&grid[x][y+1]==0&&!seen[x][y+1][t]){ // right (horizontal)
                    seen[x][y+1][t]=true;
                    queue.offer(new int[]{x,y+1,t});
                }
                if (t%2==1&&y<n-1&&grid[x][y+1]==0&&grid[x+(t==1?1:-1)][y+1]==0){ // right (vertical)
                    if (!seen[x][y+1][t]){
                        seen[x][y+1][t]=true;
                        queue.offer(new int[]{x,y+1,t});
                    }
                    if (t==3&&!seen[x-1][y+1][2]){
                        seen[x-1][y+1][2]=true; // rotate counterclockwise
                        queue.offer(new int[]{x-1,y+1,2});
                    }
                }
                if (t%2==1&&x<m-1&&grid[x+1][y]==0&&!seen[x+1][y][t]){ // down (vertical)
                    seen[x+1][y][t]=true;
                    queue.offer(new int[]{x+1,y,t});
                }
                if (t%2==0&&x<m-1&&grid[x+1][y]==0&&grid[x+1][y+(t==0?1:-1)]==0){ // down (horizontal)
                    if (!seen[x+1][y][t]){
                        seen[x+1][y][t]=true;
                        queue.offer(new int[]{x+1,y,t});
                    }
                    if (t == 2&&!seen[x+1][y-1][3]){
                        seen[x+1][y-1][3]=true; // rotate clockwise
                        queue.offer(new int[]{x+1,y-1,3});
                    }
                }
            }
            ans++;
        }
        return -1;
    }
}
