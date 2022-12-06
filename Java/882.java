class Solution {
    public int reachableNodes(int[][] edges, int maxMoves, int n) {
        List<int[]>[] map = new ArrayList[n];
        Arrays.setAll(map, o -> new ArrayList<>());
        for (int[] e : edges){
            map[e[0]].add(new int[]{e[1], e[2]});
            map[e[1]].add(new int[]{e[0], e[2]});
        }
        int[] dist = new int[n];
        int ans = 0, INF = (int)1e9;
        Arrays.fill(dist, INF);
        dist[0] = 0;
        var minheap = new PriorityQueue<int[]>(Comparator.comparingInt(o -> o[1]));
        minheap.offer(new int[]{0, 0});

        while(!minheap.isEmpty()){
            int[] top = minheap.poll();
            int cur = top[0], cost = top[1];
            if (dist[cur] != cost){
                continue;
            }
            for (int[] e : map[cur]){
                if (maxMoves - cost > e[1] && cost + e[1] + 1 < dist[e[0]]){
                    dist[e[0]] = cost + e[1] + 1;
                    minheap.offer(new int[]{e[0], dist[e[0]]});
                }
            }
            ans++;
        }
        for (int[] e : edges){
            int i = e[0], j = e[1], w = e[2];
            int a = dist[i] == INF? 0 : maxMoves - dist[i];
            int b = dist[j] == INF? 0 : maxMoves - dist[j];
            ans += Math.min(w, a+b);
        }
        return ans;
    }
}
