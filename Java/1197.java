class Solution {
    public int minKnightMoves(int x, int y) {
        x = Math.abs(x);
        y = Math.abs(y);
        int st = 10, ans = 0, m = 20;
        boolean[][] dp = new boolean[x + m][y + m];
        dp[st][st] = true;
        int[] dx = new int[]{-2, -2, -1, -1, 1, 1, 2, 2};
        int[] dy = new int[]{1, -1, 2, -2, 2, -2, 1, -1};

        while(!dp[x + st][y + st]){
            ans++;
            boolean[][] next = new boolean[x + m][y + m];
            for (int i = 0; i < x + m; i++){
                for (int j = 0; j < y + m; j++){
                    if (!dp[i][j])
                        continue;
                    for (int k = 0; k < 8; k++){
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        if (nx < 0 || ny < 0 || nx >= x + m || ny >= y + m)
                            continue;
                        next[nx][ny] = true;
                    }
                }
            }
            dp = next;
        }

        return ans;
    }
}


// class Solution {
//     public int minKnightMoves(int x, int y) {
//         x = Math.abs(x);
//         y = Math.abs(y);
//         PriorityQueue<int[]> minheap = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
//         int st = 10, m = 150, t = x + st, e = y + st;
//         minheap.offer(new int[]{dist(0, 0, x, y), st, st, 0});
//         boolean[][] visited = new boolean[x + m][y + m];
//         visited[st][st] = true;
//         int[] dx = new int[]{-2, -2, -1, -1, 1, 1, 2, 2};
//         int[] dy = new int[]{1, -1, 2, -2, 2, -2, 1, -1};

//         while(true){
//             int a = minheap.peek()[1];
//             int b = minheap.peek()[2];
//             int s = minheap.poll()[3];
//             int da = Math.abs(a - t);
//             int db = Math.abs(b - e);
//             if (a == t && b == e)
//                 return s;
//             for (int i = 0; i < 8; i++){
//                 int na = a + dx[i];
//                 int nb = b + dy[i];
//                 if (na < 0 || nb < 0 || visited[na][nb] || Math.abs(na - t) > da && Math.abs(nb - e) > db)
//                     continue;
//                 minheap.offer(new int[]{dist(na, nb, x, y) + 3 * (s + 1), na, nb, s + 1});
//                 visited[na][nb] = true;
//             }
//         }
//     }

//     private int dist(int a, int b, int c, int d){
//         return (Math.abs(a - c) + Math.abs(b - d));
//     }
// }
