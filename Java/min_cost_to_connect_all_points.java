class Solution {
    public int minCostConnectPoints(int[][] points) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        for (int i = 0; i < points.length; i++){
            for (int j = i + 1; j < points.length; j++){
                int px = points[i][0];
                int py = points[i][1];
                int qx = points[j][0];
                int qy = points[j][1];
                queue.offer(new int[]{i, j, Math.abs(px - qx) + Math.abs(py - qy)});
            }
        }

        UnionFind uf = new UnionFind(points.length);

        int min = 0;
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            if (uf.unite(cur[0], cur[1]))
                min += cur[2];
            if (uf.getCount() == 1) break;
        }

        return min;
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

        private int find(int i){
            if (nums[i] == i) return i;
            nums[i] = find(nums[i]);
            return nums[i];
        }

        private boolean unite(int i, int j){
            int iRoot = find(i);
            int jRoot = find(j);
            if (iRoot == jRoot) return false;
            count--;

            if (ranks[iRoot] < ranks[jRoot])
                nums[iRoot] = jRoot;
            else if (ranks[iRoot] > ranks[jRoot])
                nums[jRoot] = iRoot;
            else{
                nums[iRoot] = jRoot;
                ranks[jRoot]++;
            }

            return true;
        }

        private int getCount(){
            return count;
        }
    }
}
