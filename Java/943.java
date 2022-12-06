https://leetcode.com/problems/find-the-shortest-superstring/discuss/2280585/Java-or-Held-Karp-(TSP)-or-Concise-w-explanations!
class Solution {
    public String shortestSuperstring(String[] words) {
        int n = words.length;
        int[][] discount = new int[n][n];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                for (int k = 0; k < words[i].length()&&i!=j; k++){
                    if (words[j].startsWith(words[i].substring(k))){
                        discount[i][j]=words[i].length()-k;
                        break;
                    }
                }
            }
        }
        int[][] dp = new int[1<<n][n];
        int[][] path = new int[1<<n][n];
        for (int i = 0; i < 1<<n; i++){
            for (int j = 0; j < n; j++){
                for (int k = 0; k < n && (i&1<<j)>0; k++){
                    if ((i&1<<k)==0 && dp[i][j]+discount[j][k]>=dp[i|1<<k][k]){
                        dp[i|1<<k][k]=dp[i][j]+discount[j][k];
                        path[i|1<<k][k]=j;
                    }
                }
            }
        }
        int m = (1<<n)-1, idx = n;
        int end=IntStream.range(0,n).reduce((a,b)->dp[(1<<n)-1][a]>dp[(1<<n)-1][b]?a:b).getAsInt();
        String[] ans = new String[n];
        while(m>0){
            ans[--idx]=words[end].substring((m&(m-1))==0?0:discount[path[m][end]][end]);
            m^=1<<end;
            end=path[m|1<<end][end];
        }
        return String.join("",ans);
    }
}
