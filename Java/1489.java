class Solution {
    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        List<List<Integer>> ans = new ArrayList<>();
        Edge[] all = new Edge[edges.length];
        Arrays.setAll(all, o -> new Edge(edges[o][0], edges[o][1], edges[o][2], o));
        Arrays.sort(all, Comparator.comparingInt(o -> o.weight));
        int optimal = findMST(all, new UF(n));
        List<Integer> crit = new ArrayList<>();
        List<Integer> pseudo = new ArrayList<>();

        for (int i = 0; i< edges.length; i++){
            all[i].isActive = false;
            if (findMST(all, new UF(n))>optimal){
                crit.add(all[i].idx);
                all[i].isActive = true;
                continue;
            }
            UF uf = new UF(n);
            uf.union(all[i].u, all[i].v);
            if (findMST(all, uf)+all[i].weight==optimal){
                pseudo.add(all[i].idx);
            }
            all[i].isActive=true;
        }

        ans.add(crit);
        ans.add(pseudo);
        return ans;
    }

    private class Edge {
        int u;
        int v;
        int weight;
        int idx;
        boolean isActive = true;
        Edge (int u, int v, int weight, int idx){
            this.u = u;
            this.v = v;
            this.weight = weight;
            this.idx = idx;
        }
    }

    private int findMST(Edge[] edges, UF uf){
        int weight = 0;
        for (Edge e : edges){
            if (e.isActive&&uf.union(e.u, e.v)){
                weight+=e.weight;
            }
        }
        return uf.sz>1? 10000000 : weight;
    }

    private class UF {
        int sz;
        int[] parent;
        int[] rank;
        UF (int n){
            parent = IntStream.range(0, n).toArray();
            rank = new int[n];
            sz=n;
        }

        int find(int x){
            return x == parent[x]? x : (parent[x]=find(parent[x]));
        }

        boolean union(int x, int y){
            x = find(x);
            y = find(y);
            if (x == y)
                return false;
            if (rank[x]>rank[y]){
                parent[y]=x;
            }else{
                parent[x]=y;
                if (rank[x]==rank[y]){
                    rank[y]++;
                }
            }
            sz--;
            return true;
        }
    }
}
