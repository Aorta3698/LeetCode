class Solution {
    public int minCost(int maxTime, int[][] edges, int[] passingFees) {
        int INF = (int)1e9, n = passingFees.length;
        List<int[]>[] map = new ArrayList[n];
        Arrays.setAll(map, o -> new ArrayList<>());
        for (int[] e : edges){
            map[e[0]].add(new int[]{e[1], e[2]});
            map[e[1]].add(new int[]{e[0], e[2]});
        }
        int[] time = new int[n];
        Arrays.fill(time, maxTime+1);
        time[0] = 0;
        var minheap = new PriorityQueue<int[]>(Comparator.comparingInt(o -> o[2]));
        minheap.offer(new int[]{0, 0, passingFees[0]});
        while(!minheap.isEmpty()){
            int[] top = minheap.poll();
            int cur = top[0], t = top[1], cost = top[2];
            if (cur == n-1){
                return cost;
            }
            for (int[] e : map[cur]){
                int nt = t + e[1];
                if (nt < time[e[0]]){
                    time[e[0]] = nt;
                    minheap.offer(new int[]{e[0], nt, cost + passingFees[e[0]]});
                }
            }
        }
        return -1;
    }
}
