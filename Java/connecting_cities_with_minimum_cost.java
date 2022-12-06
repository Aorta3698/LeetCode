class Solution {
    public int minimumCost(int n, int[][] connections) {
        int ans = 0;
        UnionFind uf = new UnionFind(n+1);
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        for (int[] c : connections) minHeap.offer(c);
        for (int i = 0; i < connections.length; i++){
            int[] e = minHeap.poll();
            if (uf.unite(e[0], e[1])) ans += e[2];
            if (uf.getCount() == 2) return ans;
        }

        return -1;
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

        private boolean unite(int r, int p){
            r = find(r);
            p = find(p);
            if (r == p) return false;
            count--;
            if (ranks[r] > ranks[p])
                nums[p] = r;
            else if (ranks[r] < ranks[p])
                nums[r] = p;
            else{
                nums[p] = r;
                ranks[r]++;
            }

            return true;
        }

        private int getCount(){
            return count;
        }
    }
}
