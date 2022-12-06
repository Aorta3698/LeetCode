class Solution {
    public int minimumCost(int n, int[][] highways, int discounts) {
        int[][] dist = new int[discounts + 1][n];
        for (int[] d : dist){
            Arrays.fill(d, Integer.MAX_VALUE);
        }
        dist[discounts][0] = 0;
        List<int[]>[] map = new ArrayList[n];
        Arrays.setAll(map, o -> new ArrayList<>());
        for (int [] h : highways){
            map[h[0]].add(new int[]{h[1], h[2]});
            map[h[1]].add(new int[]{h[0], h[2]});
        }
        // Map<Integer, List<int[]>> map = new HashMap<>();
        // for (int[] h : highways){
        //     map.computeIfAbsent(h[0], o -> new ArrayList<>()).add(new int[]{h[1], h[2]});
        //     map.computeIfAbsent(h[1], o -> new ArrayList<>()).add(new int[]{h[0], h[2]});
        // }
        PriorityQueue<int[]> minheap = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
        minheap.offer(new int[]{0, 0, discounts});

        while(!minheap.isEmpty()){
            int d = minheap.peek()[0];
            int v = minheap.peek()[1];
            int f = minheap.poll()[2];
            if (dist[f][v] != d) continue;
            if (v == n - 1) return d;

            for (int[] next : map[v]){
                int w = next[1];
                int u = next[0];
                if (d + w < dist[f][u]){
                    for (int i = 0; i <= f; i++){
                        dist[i][u] = Math.min(d + w, dist[i][u]);
                    }
                    // dist[f][u] = d + w;
                    minheap.offer(new int[]{d + w, u, f});
                }
                if (f > 0 && (d + w / 2) < dist[f - 1][u]){
                    for (int i = 0; i < f; i++){
                        dist[i][u] = Math.min(d + w / 2, dist[i][u]);
                    }
                    // dist[f - 1][u] = d + w / 2;
                    minheap.offer(new int[]{d + w / 2, u, f - 1});
                }
            }
        }

        return -1;
    }
}
