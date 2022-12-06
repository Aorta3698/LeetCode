class Solution {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        UF alice = new UF(++n);
        UF bob = new UF(n);
        int miss = 0;
        for (int[] e : edges){
            if (e[0]==3 && (!bob.union(e[1], e[2]) | !alice.union(e[1], e[2]))){
                miss++;
            }
        }
        for (int[] e : edges){
            if (e[0]==2 && !bob.union(e[1], e[2])){
                miss++;
            }
        }
        for (int[] e : edges){
            if (e[0]==1 && !alice.union(e[1], e[2])){
                miss++;
            }
        }
        return alice.allConnected() && bob.allConnected()?
            miss : -1;
    }

    private class UF {
        int[] parent;
        int[] rank;
        int sz;
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

        boolean allConnected(){
            return sz == 2;
        }
    }
}
