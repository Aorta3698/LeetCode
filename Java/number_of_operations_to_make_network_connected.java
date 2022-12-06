class Solution {
    public int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1) return -1;
        UnionFind uf = new UnionFind(n);
        for (int[] c : connections)
            uf.unite(c[0], c[1]);

        return uf.count() - 1;
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

        private int find(int r){
            if (r != nums[r]) nums[r] = find(nums[r]);
            return nums[r];
        }

        private void unite(int x, int y){
            x = find(x);
            y = find(y);
            if (x == y) return;
            count--;
            if (ranks[x] > ranks[y])
                nums[y] = x;
            else if (ranks[x] < ranks[y])
                nums[x] = y;
            else{
                nums[x] = y;
                ranks[y]++;
            }

            return;
        }

        private int count(){
            return count;
        }
    }
}
