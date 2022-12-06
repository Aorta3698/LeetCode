class Solution {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        UnionFind uf = new UnionFind(edges.length + 1);
        HashMap<Integer, Integer> map =new HashMap<>();
        List<int[]> cand = new ArrayList<>();
        int[] parents = new int[edges.length + 1];
        parents[0] = -1; //parents count
        for (int[] e : edges){
            parents[e[1]]++; //e[1] is child, e[0] is parent
            Integer parent = map.get(e[1]);
            map.put(e[1], e[0]);
            if (!uf.unite(e[0], e[1])){
                cand.add(e);
                if (parent == null) continue;
                cand.add(new int[]{parent, e[1]});
            }
        }

        int idx = -1;
        for (int i = 0; i < parents.length; i++)
            if (parents[i] >= 2) idx = i;

        for (int[] c : cand){
            if (idx != -1 && c[1] == idx){
                if (uf.isConnected(c[0], c[1]))
                    return c;
            }
        }

        return cand.get(cand.size() - 1);
    }

    private class UnionFind{
        int[] nums;

        UnionFind(int size){
            nums = IntStream.range(0, size).toArray();
        }

        private int find(int p){
            if (nums[p] == p) return p;
            nums[p] = find(nums[p]);
            return nums[p];
        }

        private boolean unite(int parent, int child){
            int pRoot = find(parent);
            int cRoot = find(child);
            if (pRoot == cRoot || cRoot != child) return false;

            nums[child] = parent;
            return true;
        }

        private boolean isConnected(int i, int j){
            return find(i) == find(j);
        }
    }
}
