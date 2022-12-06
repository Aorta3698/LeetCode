class Solution {
    public int[] getBiggestThree(int[][] grid) {
        TreeSet<Integer> set = new TreeSet<>();
        int n = grid[0].length, m = grid.length;
        int[] dx = new int[]{0, 0, -1, 1};
        int[] dy = new int[]{1, -1, 0, 0};

        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                Queue<int[]> queue = new ArrayDeque<>();
                queue.offer(new int[]{i, j});
                boolean[][] visited = new boolean[m][n];
                visited[i][j] = true;
                boolean ok = true;
                while(ok){
                    int sz = queue.size();
                    int sum = 0;
                    while(--sz >= 0){
                        int x = queue.peek()[0];
                        int y = queue.poll()[1];
                        sum += grid[x][y];
                        for (int k = 0; k < 4 && ok; k++){
                            int a = x + dx[k];
                            int b = y + dy[k];
                            if (a < 0 || b < 0 || a == m || b == n){
                                ok = false;
                                break;
                            }
                            if (!visited[a][b]){
                                visited[a][b] = true;
                                queue.offer(new int[]{a, b});
                            }
                        }
                    }
                    set.add(sum);
                }
            }
        }

        int[] ans = new int[Math.min(3, set.size())];
        int last = Integer.MAX_VALUE;
        for (int i = 0; i < ans.length; i++){
            last = set.lower(last);
            ans[i] = last;
        }

        return ans;
    }
}
