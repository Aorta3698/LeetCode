class Solution {
    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        boolean[] ans = new boolean[queries.length];
        Query[] all = new Query[ans.length];
        for (int i = 0; i < ans.length; i++){
            all[i]=new Query(queries[i][0], queries[i][1], queries[i][2], i);
        }
        Arrays.sort(all, Comparator.comparingInt(o -> o.limit));
        Arrays.sort(edgeList, Comparator.comparingInt(o -> o[2]));
        UF uf = new UF(n);
        int i = 0, j = 0;
        while(j < ans.length){
            Query cur = all[j];
            while(i < edgeList.length && edgeList[i][2]<cur.limit){
                uf.union(edgeList[i][0], edgeList[i][1]);
                i++;
            }
            ans[cur.idx]=uf.isConnected(cur.v, cur.u);
            j++;
        }
        return ans;
    }

    private class Query {
        int v;
        int u;
        int limit;
        int idx;
        Query(int v, int u, int limit, int idx){
            this.v=v;
            this.u=u;
            this.limit=limit;
            this.idx=idx;
        }
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

        boolean isConnected(int x, int y){
            return find(x)==find(y);
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
