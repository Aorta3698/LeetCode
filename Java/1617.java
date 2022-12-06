class Solution {
    public int[] countSubgraphsForEachDiameter(int n, int[][] edges) {
        int INF = (int) 1e9;
        int[] ans = new int[n-1];
        int[][] dist = new int[n][n];
        for (int[] d : dist){
            Arrays.fill(d, INF);
        }
        for (int[] e : edges){
            e[0]--; e[1]--;
            dist[e[0]][e[1]]=dist[e[1]][e[0]]=1;
        }
        for (int k = 0; k < n; k++){
            for (int i = 0; i < n; i++){
                for (int j = 0; j < n; j++){
                    if (dist[i][k] + dist[k][j] < dist[i][j]){
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }
        for (int i = 0; i < 1<<n; i++){
            int cnt = 0, max = 0, bit = Integer.bitCount(i);
            for (int j = 0; j < n && bit > 1; j++){
                for (int k = j+1; k < n && (i & 1<<j) > 0; k++){
                    if ((i & 1<<k) > 0){
                        max = Math.max(max, dist[j][k]);
                        if (dist[j][k] == 1){
                            cnt++;
                        }
                    }
                }
            }
            if (bit > 1 && cnt == bit-1){
                ans[max-1]++;
            }
        }
        return ans;
    }
}
