class Solution {
    public int minPushBox(char[][] grid) {
        int[] t = new int[2];
        int[] b = new int[2];
        int[] s = new int[2];
        int r = grid.length;
        int c = grid[0].length;
        for (int i = 0; i < r; i++)
            for (int j = 0; j < c; j++){
                if (grid[i][j] == 'T'){
                    t[0] = i;
                    t[1] = j;
                }

                if (grid[i][j] == 'B'){
                    b[0] = i;
                    b[1] = j;
                }

                if (grid[i][j] == 'S'){
                    s[0] = i;
                    s[1] = j;
                }
            }

        Comparator<int[]> comp = (a, w) -> a[0] - w[0];
        comp = comp.thenComparing((a, w) -> w[5] - a[5]);
        PriorityQueue<int[]> queue = new PriorityQueue<>(comp);
        queue.offer(new int[]{dis(b[0], b[1], t[0], t[1]), s[0], s[1], b[0], b[1], 0});
        HashSet<String> set = new HashSet<>();
        int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int x = cur[1];
            int y = cur[2];
            int bx = cur[3];
            int by = cur[4];
            String serial = serialize(x, y, bx, by);
            set.add(serial);

            // System.out.println("x: " + x + ", y: " + y + ". bx: " + bx + ", by: " + by + ". push: " + cur[5]);

            if (grid[bx][by] == 'T') return cur[5];

            for (int[] d : dirs){
                int nx = x + d[0];
                int ny = y + d[1];
                String nSerial = serialize(nx, ny, bx, by);
                if (nx < 0 || nx >= r || ny < 0 || ny >= c
                        || grid[nx][ny] == '#' || set.contains(nSerial))
                    continue;

                int[] next = new int[6];
                if (nx == bx && ny == by){
                    int nbx = bx + d[0];
                    int nby = by + d[1];
                    if (nbx < 0 || nbx >= r || nby < 0 || nby >= c || grid[nbx][nby] == '#')
                        continue;

                    next = new int[]{1 + cur[5] + dis(nbx, nby, t[0], t[1]),
                        nx, ny, nbx, nby, cur[5] + 1};
                }else{
                    next = new int[]{cur[0], nx, ny, bx, by, cur[5]};
                }

                queue.offer(next);
            }
        }

        return -1;
    }

    private int dis(int x, int y, int tx, int ty){
        return Math.abs(tx - x) + Math.abs(ty - y);
    }

    private String serialize(int x, int y, int bx, int by){
        StringBuilder sb = new StringBuilder();
        sb.append(x);
        sb.append(',');
        sb.append(y);
        sb.append(',');
        sb.append(bx);
        sb.append(',');
        sb.append(by);
        return sb.toString();
    }
}
