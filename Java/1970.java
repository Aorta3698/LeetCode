https://leetcode.com/problems/last-day-where-you-can-still-cross/discuss/2108048/Java-or-Binary-Search-or-Union-Find
class Solution {
    public int latestDayToCross(int row, int col, int[][] cells) {
        UF uf = new UF(m*n+2);
        for (int i = 0; i < n; i++){
            uf.union(m*n, i);
            uf.union(m*n+1, m*n-i-1);
        }
        int ans = m*n-1;
        for (; !uf.isConnected(m*n, m*n+1); ans--){
            int x = cells[ans][0]-1, y = cells[ans][1]-1, cur = x*n+y;
            uf.isLand[cur] = true;
            uf.unite(cur, (x-1)*n+y);
            uf.unite(cur, (x+1)*n+y);
            uf.unite(cur, x*n+Math.min(n-1, y+1));
            uf.unite(cur, x*n+Math.max(0, y-1));
        }
        return ++ans;
    }

    private class UF {
        int[] parent;
        int[] rank;
        boolean[] isLand;
        UF (int n){
            parent = IntStream.range(0, n).toArray();
            rank = new int[n];
            isLand = new boolean[n];
        }

        int find(int x){
            return x == parent[x]? x : (parent[x] = find(parent[x]));
        }

        void unite(int x, int y){
            if (y < 0 || y >= rank.length-2 || !isLand[y])
                return;
            union(x, y);
        }

        void union(int x, int y){
            x = find(x);
            y = find(y);
            if (x == y)
                return;
            if (rank[x] > rank[y]){
                parent[y] = x;
            }else{
                parent[x] = y;
                if (rank[x] == rank[y]){
                    rank[y]++;
                }
            }
        }

        boolean isConnected(int x, int y){
            return find(x) == find(y);
        }
    }
}


class Solution {
    public int latestDayToCross(int row, int col, int[][] cells) {
        int[][] grid = new int[row][col];
        int lo = 0, hi = row*col;
        while(lo < hi){
            int mid = (lo + hi + 1) >> 1;
            for (int i = 0; i < mid; i++){
                grid[cells[i][0]-1][cells[i][1]-1] = mid;
            }
            boolean ok = false;
            for (int i = 0; i < col && !ok; i++){
                ok = dfs(0, i, grid, mid);
            }
            if (ok)
                lo = mid;
            else
                hi = mid - 1;
        }
        return lo;
    }

    private boolean dfs(int i, int j, int[][] grid, int visited){
        if (i < 0 || j < 0 || i == grid.length || j == grid[0].length || grid[i][j] == visited)
            return false;
        grid[i][j] = visited;
        return i == grid.length - 1
            || dfs(i + 1, j, grid, visited)
            || dfs(i - 1, j, grid, visited)
            || dfs(i, j + 1, grid, visited)
            || dfs(i, j - 1, grid, visited);
    }
}
