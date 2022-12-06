class Solution {
    public int minCostConnectPoints(int[][] P) {
        int[] dist = new int[P.length];
        boolean[] seen = new boolean[P.length];
        Arrays.fill(dist, Integer.MAX_VALUE);
        int cur = 0, next = -1, ans = 0;
        dist[cur] = 0;

        for (int i = 1; i < P.length; i++){
            seen[cur] = true;
            for (int j = 0; j < P.length; j++){
                if (seen[j])
                    continue;
                dist[j] = Math.min(dist[j], Math.abs(P[j][0] - P[cur][0]) + Math.abs(P[j][1] - P[cur][1]));
                if (next == -1 || dist[j] < dist[next]){
                    next = j;
                }
            }
            ans += dist[next];
            cur = next;
            next = -1;
        }

        return ans;
    }
}
