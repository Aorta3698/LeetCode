class Solution {
    public int countComponents(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);
        for (int[] e : edges)
            uf.unite(e[0], e[1]);

        return uf.getCount();
    }

    private class UnionFind{
        int[] nums;
        int[] ranks;
        int count;

        UnionFind(int size){
            nums = IntStream.range(0, size).toArray();
            ranks = new int[size];
            count = size;
        }

        private int find(int n){
            if (nums[n] == n) return n;
            nums[n] = find(nums[n]);
            return nums[n];
        }

        private void unite(int a, int b){
            int aRoot = find(a);
            int bRoot = find(b);
            if (aRoot == bRoot) return;
            count--;

            if (ranks[aRoot] < ranks[bRoot])
                nums[aRoot] = bRoot;
            else if (ranks[aRoot] > ranks[bRoot])
                nums[bRoot] = aRoot;
            else{
                nums[aRoot] = bRoot;
                ranks[bRoot]++;
            }
        }

        private int getCount(){
            return count;
        }
    }
}
