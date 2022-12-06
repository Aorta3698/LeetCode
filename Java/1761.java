https://leetcode.com/problems/minimum-degree-of-a-connected-trio-in-a-graph/discuss/2186219/What-is-the-point-of-this-question
class Solution {
    public int minTrioDegree(int n, int[][] edges) {
        ++n;
        boolean[][] ok = new boolean[n][n];
        int[] deg = new int[n];
        for (int[] e : edges){
            ok[e[0]][e[1]]=ok[e[1]][e[0]]=true;
            deg[e[0]]++;
            deg[e[1]]++;
        }
        int ans = (int)1e9;
        for (int i = 0; i < n; i++){
            for (int j = i + 1; j < n; j++){
                for (int k = j + 1; k < n && (ok[i][j]||ok[j][i]); k++){
                    if ((ok[k][j]||ok[j][k]) && (ok[i][k]||ok[k][i])){
                        ans = Math.min(ans, deg[i]+deg[j]+deg[k]-6);
                    }
                }
            }
        }
        return ans == (int)1e9? -1 : ans;
    }
}
