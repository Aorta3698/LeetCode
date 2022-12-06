class Solution {
    public List<Boolean> areConnected(int n, int threshold, int[][] queries) {
        List<Boolean> ans = new ArrayList<>();
        UF uf = new UF(n+1);
        for (int i = threshold+1; i <= n; i++){
            for (int j = 2*i; j <= n; j+=i){
                uf.union(i, j);
            }
        }
        for (int i = 0; i< queries.length; i++){
            ans.add(uf.find(queries[i][0])==uf.find(queries[i][1]));
        }
        return ans;
    }

    private class UF {
        int[] parent;
        int[] rank;
        UF (int n){
            parent = IntStream.range(0, n).toArray();
            rank = new int[n];
        }

        int find(int x){
            return x == parent[x]? x : (parent[x]=find(parent[x]));
        }

        void union(int x, int y){
            x = find(x);
            y = find(y);
            if (x == y)
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
