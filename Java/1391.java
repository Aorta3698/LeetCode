https://leetcode.com/problems/check-if-there-is-a-valid-path-in-a-grid/discuss/1958551/Java-or-3-Solutions-or-UF-or-BFS-or-Simulation
class Solution {
    public boolean hasValidPath(int[][] grid) {
        int[][][] dirs = {
            {{0, 1}, {0, -1}},
            {{1, 0}, {-1, 0}},
            {{0, -1}, {1, 0}},
            {{0, 1}, {1, 0}},
            {{-1, 0}, {0, -1}},
            {{-1, 0}, {0, 1}}
        };
        int n = grid[0].length, m = grid.length;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{0, 0});
        boolean[][] visited = new boolean[m][n];
        visited[0][0] = true;
        while(!queue.isEmpty()){
            int x = queue.peek()[0];
            int y = queue.poll()[1];
            for (int[] d : dirs[grid[x][y] - 1]){
                int nx = x + d[0];
                int ny = y + d[1];
                if (nx < 0 || ny < 0 || nx == m || ny == n || visited[nx][ny])
                    continue;
                for (int[] dd : dirs[grid[nx][ny] - 1]){
                    if (nx + dd[0] == x && ny + dd[1] == y){
                        visited[nx][ny] = true;
                        queue.offer(new int[]{nx, ny});
                    }
                }
            }
        }
        return visited[m - 1][n - 1];
    }
}

//     int n, m;
//     public boolean hasValidPath(int[][] grid) {
//         n = grid[0].length; m = grid.length;
//         UF uf = new UF((2 * n + 1) * (2 * m + 1));
//         for (int i = 0; i < grid.length; i++){
//             for (int j = 0; j < grid[0].length; j++){
//                 int v = grid[i][j];
//                 if (v == 2 || v == 5 || v == 6){
//                     uf.union(id(i, j, 0, 0), id(i, j, -1, 0));
//                 }
//                 if (v == 1 || v == 4 || v == 6){
//                     uf.union(id(i, j, 0, 0), id(i, j, 0, 1));
//                 }
//                 if (v == 2 || v == 3 || v == 4){
//                     uf.union(id(i, j, 0, 0), id(i, j, 1, 0));
//                 }
//                 if (v == 1 || v == 3 || v == 5){
//                     uf.union(id(i, j, 0, 0), id(i, j, 0, -1));
//                 }
//             }
//         }
//         return uf.find(id(0, 0, 0, 0)) == uf.find(id(m - 1, n - 1, 0, 0));
//     }

//     private int id(int i, int j, int di, int dj){
//         return (di + 2 * i + 1) * (2 * n + 1) + (dj + 2 * j + 1);
//     }

//     private class UF {
//         int[] parent;
//         int[] rank;

//         UF (int n){
//             parent = IntStream.range(0, n).toArray();
//             rank = new int[n];
//         }

//         int find(int x){
//             return x == parent[x]? x : (parent[x] = find(parent[x]));
//         }

//         void union(int x, int y){
//             x = find(x);
//             y = find(y);
//             if (x == y)
//                 return;
//             if (rank[x] > rank[y]){
//                 parent[y] = x;
//             }else{
//                 parent[x] = y;
//                 if (rank[x] == rank[y]){
//                     rank[y]++;
//                 }
//             }
//         }
//     }
// }

// class Solution {
//     public boolean hasValidPath(int[][] grid) {
//         int x = 0, y = 0, n = grid[0].length, m = grid.length, v = grid[0][0];
//         int UP = 0, DOWN = 1, RIGHT = 2, LEFT = 3;
//         List<Integer> st = new ArrayList<>();
//         boolean[][] valid = new boolean[7][4];
//         valid[1][RIGHT] = valid[1][LEFT] = valid[2][UP] = valid[2][DOWN] = valid[3][RIGHT] = valid[3][UP] = true;
//         valid[4][UP] = valid[4][LEFT] = valid[5][RIGHT] = valid[5][DOWN] = valid[6][LEFT] = valid[6][DOWN] = true;
//         if (v == 1 || v == 3){
//             st.add(RIGHT);
//         }
//         if (v == 2 || v == 6){
//             st.add(DOWN);
//         }
//         if (v == 4){
//             st.add(LEFT);
//             st.add(UP);
//         }
//         if (n == 1 && m == 1)
//             return true;
//
//         for (int d : st){
//             while(x >= 0 && y >= 0 && x < m && y < n && grid[x][y] > 0 && valid[grid[x][y]][d]){
//                 if (x == m - 1 && y == n - 1)
//                     return true;
//                 v = grid[x][y];
//                 if (x > 0 && y > 0){
//                     grid[x][y] = 0;
//                 }
//                 switch(v){
//                     case 1 -> y = d == RIGHT? ++y : --y;
//                     case 2 -> x = d == DOWN? ++x : --x;
//                     case 3 -> {
//                         if (d == RIGHT){
//                             ++x;
//                             d = DOWN;
//                         }else{
//                             --y;
//                             d = LEFT;
//                         }
//                     }
//                     case 4 -> {
//                         if (d == LEFT){
//                             ++x;
//                             d = DOWN;
//                         }else{
//                             ++y;
//                             d = RIGHT;
//                         }
//                     }
//                     case 5 -> {
//                         if (d == RIGHT){
//                             --x;
//                             d = UP;
//                         }else{
//                             --y;
//                             d = LEFT;
//                         }
//                     }
//                     case 6 -> {
//                         if (d == LEFT){
//                             --x;
//                             d = UP;
//                         }else{
//                             ++y;
//                             d = RIGHT;
//                         }
//                     }
//                 }
//             }
//         }
//         return false;
//     }
// }
