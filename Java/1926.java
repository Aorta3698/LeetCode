class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int n = maze[0].length, m = maze.length, ans = 0;
        int[] dx = new int[]{1, -1, 0, 0};
        int[] dy = new int[]{0, 0, 1, -1};
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(entrance);

        while(!queue.isEmpty()){
            int sz = queue.size();
            while(--sz >= 0){
                int[] cur = queue.poll();
                int x = cur[0], y = cur[1];
                if (!Arrays.equals(entrance, cur) && (x == 0 || y == 0 || x == m - 1 || y == n - 1)){
                    return ans;
                }
                for (int i = 0; i < 4; i++){
                    int a = x + dx[i], b = y + dy[i];
                    if (a < 0 || b < 0 || a == m || b == n || maze[a][b] != '.'){
                        continue;
                    }
                    queue.offer(new int[]{a, b});
                    maze[a][b] = '+';
                }
            }
            ans++;
        }

        return -1;
    }
}
