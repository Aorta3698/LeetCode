class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        if (src == dst) return 0;
        int[] dist = new int[n];
        int[] prevDist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        prevDist = dist.clone();
        for (int i = 1; i < k + 2; i++){
            for (int[] f : flights){
                int o = f[0];
                int d = f[1];
                int w = f[2];
                if (prevDist[o] != Integer.MAX_VALUE && prevDist[o] + w < dist[d])
                    dist[d] = prevDist[o] + w;
            }
            prevDist = dist.clone();
        }

        return dist[dst] == Integer.MAX_VALUE? -1 : dist[dst];
    }
}
