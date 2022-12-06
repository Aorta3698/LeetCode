class Solution {
    public boolean validPath(int n, int[][] edges, int start, int end) {
        UnionFind uf = new UnionFind(n);
        for (int[] e : edges)
            uf.unite(e[0], e[1]);

        return uf.isConnected(start, end);
    }

    private class UnionFind{
        int[] nums;
        int[] ranks;

        UnionFind(int size){
            nums = IntStream.range(0, size).toArray();
            ranks = new int[size];
        }

        private int find(int i){
            if (i == nums[i]) return i;
            nums[i] = find(nums[i]);
            return nums[i];
        }

        private void unite(int i, int j){
            int iRoot = find(i);
            int jRoot = find(j);
            if (iRoot == jRoot) return;
            if (ranks[iRoot] < ranks[jRoot])
                nums[iRoot] = jRoot;
            else if (ranks[iRoot] > ranks[jRoot])
                nums[jRoot] = iRoot;
            else{
                nums[iRoot] = jRoot;
                ranks[jRoot]++;
            }
        }

        private boolean isConnected(int i, int j){
            return find(i) == find(j);
        }
    }
}
