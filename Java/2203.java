https://leetcode.com/problems/minimum-weighted-subgraph-with-the-required-paths/discuss/2193309/Java-or-Dijkstra-x-3-or-Common-Node
class Solution {
    long INF = (long)1e11;
    public long minimumWeight(int n, int[][] edges, int src1, int src2, int dest) {
        List<int[]>[] map = new ArrayList[n];
        List<int[]>[] reverseMap = new ArrayList[n];
        Arrays.setAll(map, o -> new ArrayList<>());
        Arrays.setAll(reverseMap, o -> new ArrayList<>());
        for (int[] e : edges){
            map[e[0]].add(new int[]{e[1], e[2]});
            reverseMap[e[1]].add(new int[]{e[0], e[2]});
        }

        long[] destDist = dijkstra(n, dest, reverseMap);
        long[] src1Dist = dijkstra(n ,src1, map);
        long[] src2Dist = dijkstra(n, src2, map);
        long ans = INF;
        for (int i = 0 ; i < n; i++){
            ans = Math.min(ans, destDist[i]+src1Dist[i]+src2Dist[i]);
        }

        return ans==INF? -1:ans;
    }

    private long[] dijkstra(int n, int src, List<int[]>[] map){
        long[] dist = new long[n];
        Arrays.fill(dist, INF);
        dist[src] = 0;
        PriorityQueue<long[]> minheap = new PriorityQueue<>(Comparator.comparingLong(o -> o[0]));
        minheap.offer(new long[]{0L, src});

        while(!minheap.isEmpty()){
            long[] top = minheap.poll();
            long d = top[0];
            int cur = (int)top[1];
            if (d != dist[cur]){
                continue;
            }
            for (int[] e : map[cur]){
                long nd = e[1] + d;
                int next = e[0];
                if (nd < dist[next]){
                    dist[next] = nd;
                    minheap.offer(new long[]{nd, next});
                }
            }
        }

        return dist;
    }
}
