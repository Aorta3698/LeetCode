class Solution {
    public long countPairs(int n, int[][] edges) {
        long ans = 0;
        UF uf = new UF(n);
        for (int[] e : edges){
            uf.union(e[0], e[1]);
        }
        for (int i = 0; i < n; i++){
            int parent = uf.find(i);
            ans += 1L * uf.size[parent] * (n - uf.size[parent]);
            uf.size[parent]=0;
        }
        return ans/2;
    }

    private class UF {
        int[] size;
        int[] parent;
        UF (int n){
            size = new int[n];
            Arrays.fill(size, 1);
            parent = IntStream.range(0, n).toArray();
        }

        int find(int x){
            return parent[x]==x? x : (parent[x]=find(parent[x]));
        }

        void union(int x, int y){
            x = find(x);
            y = find(y);
            if (x == y){
                return;
            }
            if (size[x]>size[y]){
                size[x]+=size[y];
                parent[y]=x;
            }else{
                size[y]+=size[x];
                parent[x]=y;
            }
        }
    }
}
