class Solution {
    public int numSimilarGroups(String[] strs) {
        UF uf = new UF(strs.length);
        for (int i = 0; i < strs.length; i++){
            for (int j = i+ 1; j < strs.length; j++){
                int miss = 0;
                for (int k = 0; k < strs[0].length(); k++){
                    if (strs[i].charAt(k)!=strs[j].charAt(k) && ++miss==3){
                        break;
                    }
                }
                if (miss==2||miss==0){
                    uf.union(i, j);
                }
            }
        }
        return uf.sz;
    }

    private class UF {
        int[] parent;
        int[] rank;
        int sz;
        UF (int n){
            parent = IntStream.range(0, n).toArray();
            rank = new int[n];
            sz = n;
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
            sz--;
        }
    }
}
