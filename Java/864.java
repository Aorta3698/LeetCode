class Solution {
    public int shortestPathAllKeys(String[] grid) {
        Queue<int[]> queue = new ArrayDeque<>();
        int m = grid.length, n = grid[0].length(), sx = 0, sy = 0, keys = 0;
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                char v = grid[i].charAt(j);
                if (v == '@'){
                    sx = i;
                    sy = j;
                }else if (v >= 'a' && v <= 'f'){
                    keys++;
                }
            }
        }

        boolean[][][] seen = new boolean[1<<keys][m][n];
        seen[0][sx][sy]=true;
        queue.offer(new int[]{0, sx, sy});
        int[] dx = new int[]{0, 0, 1, -1};
        int[] dy = new int[]{1, -1, 0, 0};
        int ans = 0, end = (1 << keys) - 1;

        while(!queue.isEmpty()){
            for (int sz = queue.size(); sz > 0; sz--){
                int[] cur = queue.poll();
                int k = cur[0];
                int x = cur[1];
                int y = cur[2];
                if (k == end)
                    return ans;
                for (int i = 0; i < 4; i++){
                    int nx = x+dx[i];
                    int ny = y+dy[i];
                    int nk = k;
                    if (nx < 0 || ny < 0 || nx == m || ny == n)
                        continue;
                    char nv = grid[nx].charAt(ny);
                    if (nv == '#' || nv>='A'&&nv<='F'&&(nk&(1 << (nv-'A')))==0)
                        continue;
                    if (nv>='a'&&nv<='f'){
                        nk |= 1 << (nv-'a');
                    }
                    if (!seen[nk][nx][ny]){
                        seen[nk][nx][ny]=true;
                        queue.offer(new int[]{nk, nx, ny});
                    }
                }
            }
            ans++;
        }

        return -1;
    }
}
