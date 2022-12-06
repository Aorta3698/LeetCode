class Solution {
    public int[][] highestPeak(int[][] isWater) {
        int m = isWater.length, n = isWater[0].length;
        List<int[]> water = new ArrayList<>();
        Queue<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (isWater[i][j] == 1){
                    isWater[i][j] = -1;
                    water.add(new int[]{i, j});
                    queue.add(new int[]{i, j});
                }
            }
        }
        int dist = 0;
        int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        while(!queue.isEmpty()){
            int sz = queue.size();
            while(--sz >= 0){
                int[] cur = queue.poll();
                int a = cur[0];
                int b = cur[1];
                if (isWater[a][b] > 0) continue;
                if (dist > 0)
                    isWater[a][b] = dist;
                for (int[] d : dirs){
                    int x = a + d[0];
                    int y = b + d[1];
                    if (x < 0 || x >= m || y < 0 || y >= n || isWater[x][y] != 0) continue;
                    queue.offer(new int[]{x, y});
                }
            }
            dist++;
        }
        for (int[] w : water){
            isWater[w[0]][w[1]] = 0;
        }
        return isWater;
    }
}
