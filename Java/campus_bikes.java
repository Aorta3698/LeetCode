class Solution {
    public int[] assignBikes(int[][] workers, int[][] bikes) {
        int[] ans = new int[workers.length];
        Arrays.fill(ans, -1);
        Comparator<int[]> cmp = Comparator.comparingInt(o -> o[0]);
        cmp = cmp.thenComparing(o -> o[1]);
        cmp = cmp.thenComparing(o -> o[2]);

        PriorityQueue<int[]> minheap = new PriorityQueue<>(cmp);
        for (int i = 0; i < workers.length; i++)
            for (int j = 0; j < bikes.length; j++)
                minheap.offer(new int[]{dist(workers[i], bikes[j]), i, j});

        int count = 0;
        boolean[] taken = new boolean[bikes.length];
        while(count < ans.length){
            int[] cur = minheap.poll();
            int w = cur[1];
            int b = cur[2];
            if (ans[w] == -1 && !taken[b]){
                count++;
                ans[w] = b;
                taken[b] = true;
            }
        }

        return ans;
    }

    private int dist(int[] w, int[] b){
        return Math.abs(w[0] - b[0]) + Math.abs(w[1] - b[1]);
    }
}
