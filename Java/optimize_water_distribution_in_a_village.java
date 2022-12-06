class Solution {
    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        //KURSKAL's ALGO
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        for (int i = 1; i <= wells.length; i++) queue.offer(new int[]{0, i, wells[i-1]});
        for (int[] p : pipes) queue.offer(p);

        UnionFind uf = new UnionFind(n + 1);
        int ans = 0;
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            if (uf.unite(cur[0], cur[1])){
                ans += cur[2];
                if (uf.getCount() == 1)
                    break;
            }
        }

        return ans;
    }

    private class UnionFind{
        int[] nums;
        int[] ranks;
        int count;

        UnionFind(int size){
            count = size;
            nums = IntStream.range(0, size).toArray();
            ranks = new int[size];
        }

        private int find(int i){
            if (nums[i] == i) return i;
            nums[i] = find(nums[i]);
            return nums[i];
        }

        private boolean unite(int i, int j){
            int iRoot = find(i);
            int jRoot = find(j);
            if (iRoot == jRoot) return false;
            if (ranks[iRoot] > ranks[jRoot])
                nums[jRoot] = iRoot;
            else if (ranks[iRoot] < ranks[jRoot])
                nums[iRoot] = jRoot;
            else{
                nums[iRoot] = jRoot;
                ranks[jRoot]++;
            }

            count--;
            return true;
        }

        private int getCount(){
            return count;
        }
    }
}
