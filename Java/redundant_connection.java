class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        UnionFind uf = new UnionFind(edges.length+1);
        for (int[] e : edges)
            if(!uf.unite(e[0], e[1]))
                return e;

        return null;
    }

    private class UnionFind{
        int[] nums;
        int[] ranks;

        UnionFind(int size){
            nums = IntStream.range(0, size).toArray();
            ranks = new int[size];
        }

        private int find(int p){
            if (nums[p] == p) return p;
            nums[p] = find(nums[p]);
            return nums[p];
        }

        private boolean unite(int a, int b){
            int aRoot = find(a);
            int bRoot = find(b);
            if (aRoot == bRoot) return false;
            if (ranks[aRoot] > ranks[bRoot])
                nums[bRoot] = aRoot;
            else if (ranks[aRoot] < ranks[bRoot])
                nums[aRoot] = bRoot;
            else{
                nums[aRoot] = bRoot;
                ranks[bRoot]++;
            }

            return true;
        }
    }
}
