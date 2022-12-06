class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        double ans = 0;
        PriorityQueue<int[]> maxheap = new PriorityQueue<>(
                (Comparator.comparingDouble(o -> -((o[0] + 1f) / (o[1] + 1f) - 1.0 * o[0] / o[1]))));
        for (int[] c : classes){
            maxheap.offer(c);
        }
        while(--extraStudents >= 0){
            int[] cur = maxheap.poll();
            cur[0]++;
            cur[1]++;
            maxheap.offer(cur);
        }
        while(!maxheap.isEmpty()){
            int[] cur = maxheap.poll();
            ans += 1.0 * cur[0] / cur[1];
        }

        return ans / classes.length;
    }
}
