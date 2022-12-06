https://leetcode.com/problems/bricks-falling-when-hit/discuss/2172323/Java-or-Union-By-Size-or-Dummy-Node-or-Clean-Code.
class Solution {
    public int[] hitBricks(int[][] grid, int[][] hits) {
        int[] ans = new int[hits.length];
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < hits.length; i++){
            if (grid[hits[i][0]][hits[i][1]]==1){
                grid[hits[i][0]][hits[i][1]]=0;
            }else{
                hits[i]=null;
            }
        }
        UF uf = new UF(m*n+1, n);
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                uf.union(i, j, i + 1, j, grid);
                uf.union(i, j, i, j + 1, grid);
            }
        }
        for (int i = hits.length - 1; i >= 0; i--){
            if (hits[i]==null){
                continue;
            }
            int a = hits[i][0];
            int b = hits[i][1];
            grid[a][b]=1;
            ans[i] = uf.union(a, b, a + 1, b, grid)
                   + uf.union(a, b, a - 1, b, grid)
                   + uf.union(a, b, a, b + 1, grid)
                   + uf.union(a, b, a, b - 1, grid)
                   - (a == 0? 0 : 1);
            ans[i] = Math.max(ans[i], 0);
        }
        return ans;
    }

    private class UF {
        int[] sz;
        int[] parent;
        UF (int sz, int n){
            parent = IntStream.range(0, sz).toArray();
            this.sz = new int[sz];
            Arrays.fill(this.sz, 1);
            for (int i=1; i<1+n;i++){
                parent[i]=0;
            }
        }

        private int find(int x){
            return x == parent[x]? x : (parent[x]=find(parent[x]));
        }

        private boolean withinBounds(int a, int b, int[][] grid){
            return !(a < 0 || b < 0 || a == grid.length || b == grid[0].length);
        }

        private int union(int i, int j, int a, int b, int[][] grid){
            if (!withinBounds(i, j, grid) || !withinBounds(a, b, grid))
                return 0;
            if (grid[i][j]==0 || grid[a][b] == 0)
                return 0;

            int x = find(1 + i*grid[0].length + j);
            int y = find(1 + a*grid[0].length + b);
            if (x == y)
                return 0;
            if (x==0){
                parent[y]=x;
                sz[x]+=sz[y];
                return sz[y];
            }else if (y==0){
                parent[x]=y;
                sz[y]+=sz[x];
                return sz[x];
            }else{
                parent[x]=y;
                sz[y]+=sz[x];
                return 0;
            }
        }
    }
}
