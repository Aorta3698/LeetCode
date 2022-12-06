https://leetcode.com/problems/maximum-path-quality-of-a-graph/discuss/2180428/DIjkstra%2B-DFS-(93ms-95-Speed)-or-Java
class Solution {
    public int maximalPathQuality(int[] values, int[][] edges, int maxTime) {
        Map<Integer, List<int[]>> map = new HashMap<>();
        for (int[] e : edges){
            map.computeIfAbsent(e[0], o -> new ArrayList<>()).add(new int[]{e[1], e[2]});
            map.computeIfAbsent(e[1], o -> new ArrayList<>()).add(new int[]{e[0], e[2]});
        }
        int[] dist = new int[values.length];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0]=0;
        PriorityQueue<int[]> minheap = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
        minheap.offer(new int[]{0, 0});
        while(!minheap.isEmpty()){
            int[] cur = minheap.poll();
            int d = cur[0];
            int u = cur[1];
            if (d!=dist[u]){
                continue;
            }
            for (int[] info : map.getOrDefault(u, List.of())){
                int w = info[1];
                int v = info[0];
                if (d + w < dist[v]){
                    dist[v] = d+w;
                    minheap.offer(new int[]{dist[v], v});
                }
            }
        }

        return solve(0, maxTime, values, dist, map);
    }

    private int solve(int i, int remainT, int[] values, int[] dist, Map<Integer, List<int[]>> map){
        if (remainT < dist[i])
            return 0;
        int tmp = values[i];
        int ans = 0;
        values[i] = 0;
        for (int[] next : map.getOrDefault(i, List.of())){
            ans = Math.max(ans, solve(next[0], remainT - next[1], values, dist, map));
        }
        values[i] = tmp;
        return ans+tmp;
    }
}
