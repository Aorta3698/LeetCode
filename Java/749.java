https://leetcode.com/problems/contain-virus/discuss/2169784/Traverse-the-grid-2-times-with-DSU-and-DFS-Modular-w-Diagram
class Solution {
    int m, n;
    int VIRUS = 1;
    int ID = 2;
    public int containVirus(int[][] isInfected) {
        m = isInfected.length;
        n = isInfected[0].length;
        int ans = 0;
        Comparator<Virus> comp = Comparator.comparingInt(o -> -o.border.size());
        PriorityQueue<Virus> maxheap = new PriorityQueue<>(comp);
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (isInfected[i][j]==VIRUS){
                    Set<Integer> border = new HashSet<>();
                    int id = maxheap.size()+ID;
                    int walls = mark(i, j, id, isInfected, border, null, null);
                    maxheap.offer(new Virus(id, walls, border));
                }
            }
        }

        Virus[] virus = new Virus[maxheap.size()+ID];
        UF uf = new UF(virus.length);

        while(!maxheap.isEmpty()){
            Virus killed = maxheap.poll();
            ans += killed.walls;
            virus[killed.id]=null;
            PriorityQueue<Virus> next = new PriorityQueue<>(comp);
            for (Virus v : maxheap){
                for (int p : v.border){
                    isInfected[p/n][p%n]=VIRUS;
                }
            }
            for (Virus v : maxheap){
                int walls = 0;
                Set<Integer> nb = new HashSet<>();
                for (int p : v.border){
                    walls += mark(p/n, p%n, v.id, isInfected, nb, uf, virus);
                }
                virus[v.id]=new Virus(v.id, walls, nb);
            }
            for (int i = ID; i < virus.length; i++){
                if (isAliveVirus(i, uf, virus) && !uf.isRoot(i)){
                    virus[uf.find(i)].walls+=virus[i].walls;
                    virus[uf.find(i)].border.addAll(virus[i].border);
                    virus[i] = new Virus(i, 0, new HashSet<>());
                }
            }
            for (int i = ID; i < virus.length; i++){
                if (isAliveVirus(i, uf, virus) && uf.isRoot(i)){
                    next.offer(virus[i]);
                }
            }
            maxheap = next;
        }

        return ans;
    }

    private boolean isAliveVirus(int id, UF uf, Virus[] virus){
        return virus[uf.find(id)]!=null;
    }

    private boolean isVirus(int id){
        return id >= ID;
    }

    private boolean isDeadVirus(int id, UF uf, Virus[] virus){
        return isVirus(id) && !isAliveVirus(id, uf, virus);
    }

    private int mark(int i, int j, int id, int[][] grid, Set<Integer> border, UF uf, Virus[] virus){
        if (i < 0 || j < 0 || i == m || j == n || grid[i][j]==id || isDeadVirus(grid[i][j], uf, virus))
            return 0;
        if (isVirus(grid[i][j])){
            uf.union(grid[i][j], id);
            return 0;
        }
        if (grid[i][j]==0){
            border.add(i*n+j);
            return 1;
        }
        grid[i][j]=id;
        return mark(i+1, j, id, grid, border, uf, virus)
            +  mark(i-1, j, id, grid, border, uf, virus)
            +  mark(i, j+1, id, grid, border, uf, virus)
            +  mark(i, j-1, id, grid, border, uf, virus);
    }

    private class Virus {
        int id;
        int walls;
        Set<Integer> border;
        Virus(int id, int walls, Set<Integer> border){
            this.id = id;
            this.walls = walls;
            this.border = border;
        }
        Virus(){}
    }

    private class UF {
        int[] parent;
        int[] rank;
        UF (int n){
            parent = IntStream.range(0, n).toArray();
            rank = new int[n];
        }

        private int find(int x){
            return x == parent[x]? x : (parent[x]=find(parent[x]));
        }

        private boolean isRoot(int x){
            return x == parent[x];
        }

        private void union(int x, int y){
            x = find(x);
            y = find(y);
            if (x==y)
                return;
            if (rank[x]>rank[y]){
                parent[y]=x;
            }else{
                parent[x]=y;
                if (rank[x]==rank[y]){
                    rank[y]++;
                }
            }
        }
    }
}
