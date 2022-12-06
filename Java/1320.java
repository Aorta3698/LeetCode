class Solution {
    public int minimumDistance(String word) {
        int N = word.length(), INF = (int)1e9, ans = INF;
        int[][] dp = new int[26][26];
        int[][] dist = new int[26][26];
        for (int i = 0; i < 26; i++){
            for (int j = i+1; j < 26; j++){
                dist[i][j] = dist[j][i] = Math.abs(i/6-j/6)+Math.abs(i%6-j%6);
            }
        }
        for (int i = 0; i < N; i++){
            int[][] next = new int[26][26];
            for (int j = 0; j < 26; j++){
                Arrays.fill(next[j], INF);
            }
            for (int j = 0; j < 26; j++){
                for (int k = 0; k < 26; k++){
                    if (dp[j][k]!=INF){
                        int v = word.charAt(i)-'A';
                        next[v][k]=Math.min(dp[j][k]+dist[j][v], next[v][k]);
                        next[j][v]=Math.min(dp[j][k]+dist[k][v], next[j][v]);
                    }
                }
            }
            dp=next;
        }
        for (int i = 0; i < 26; i++){
            for (int j = 0; j < 26; j++){
                ans = Math.min(ans, dp[i][j]);
            }
        }
        return ans;
    }
}
