class DistanceLimitedPathsExist {

    UF uf;
    public DistanceLimitedPathsExist(int n, int[][] edgeList) {
        uf = new UF(n);
        Arrays.sort(edgeList, Comparator.comparingInt(o -> o[2]));
        for (int[] e : edgeList){
            uf.union(e[0], e[1], e[2]);
        }
    }

    public boolean query(int p, int q, int limit) {
        return uf.isConnected(p, q, limit-1);
    }

    private class UF {
        TreeMap<Integer, Integer>[] parent;
        int[] rank;
        UF (int n){
            parent = new TreeMap[n];
            Arrays.setAll(parent, o -> new TreeMap<>(Map.of(0, o)));
            rank = new int[n];
        }

        int getParent(int x, int weight){
            return parent[x].floorEntry(weight).getValue();
        }

        int setParent(int x, int weight, int y){
            parent[x].put(weight, y);
            return y;
        }

        int find(int x, int weight){
            int pval = getParent(x, weight);
            return x == pval?
                x : setParent(x, weight, find(pval, weight));
        }

        boolean isConnected(int x, int y, int weight){
            return find(x, weight)==find(y, weight);
        }

        void union(int x, int y, int weight){
            x = find(x, weight);
            y = find(y, weight);
            if (x == y)
                return;
            if (rank[x]>rank[y]){
                setParent(y, weight, x);
            }else{
                setParent(x, weight, y);
                if (rank[x]==rank[y]){
                    rank[y]++;
                }
            }
        }
    }
}

/**
 * Your DistanceLimitedPathsExist object will be instantiated and called as such:
 * DistanceLimitedPathsExist obj = new DistanceLimitedPathsExist(n, edgeList);
 * boolean param_1 = obj.query(p,q,limit);
 */
