class Solution {
    public int getFood(char[][] grid) {
        List<int[]> foods = new ArrayList<>();
        int[] s = new int[2];
        int r = grid.length;
        int c = grid[0].length;
        for (int i = 0; i < r; i++)
            for (int j = 0; j < c; j++){
                if (grid[i][j] == '#')
                    foods.add(new int[]{i, j});
                else if (grid[i][j] == '*')
                    s = new int[]{i, j};
            }

        HashSet<String> seen = new HashSet<>();
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int[] food : foods){
            int fx = food[0];
            int fy = food[1];
            int priority = dist(s[0], s[1], fx, fy);
            queue.offer(new int[]{priority, s[0], s[1], fx, fy, 0});
                //priorty, cur X, cur Y, food X, food Y, steps
        }
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int curX = cur[1];
            int curY = cur[2];
            int foodX = cur[3];
            int foodY = cur[4];
            int step = cur[5];
            String serial = curX + "," + curY + "," + foodX + "," + foodY;
            if (seen.contains(serial)) continue;
            if (curX == foodX && curY == foodY) return step;
            seen.add(serial);

            for (int[] d : dirs){
                int nx = curX + d[0];
                int ny = curY + d[1];
                String nSerial = nx + "," + ny + "," + foodX + "," + foodY;
                if (nx < 0 || nx >= r || ny < 0 || ny >= c
                        || grid[nx][ny] == 'X' || seen.contains(nSerial))
                    continue;

                int priority = dist(nx, ny, foodX, foodY) + step + 1;
                queue.offer(new int[]{priority, nx, ny, foodX, foodY, step + 1});
            }
        }

        return -1;
    }

    private int dist(int x, int y, int fx, int fy){
        return Math.abs(x - fx) + Math.abs(y - fy);
    }
}
