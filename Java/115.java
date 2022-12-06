https://leetcode.com/problems/distinct-subsequences/discuss/2215660/Java-or-Many-Many-Solutions
class Solution {
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();
        int[] dp = new int[n+1];
        dp[0]=1;
        for (int i = 1; i <= m; i++){
            for (int j = n; j >= 1; j--){
                if (s.charAt(i-1)==t.charAt(j-1)){
                    dp[j]+=dp[j-1];
                }
            }
        }
        return dp[n];
    }
}

class Solution {
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();
        int[] dp = new int[n+1];
        dp[0]=1;
        for (int i = 1; i <= m; i++){
            int[] next = new int[n+1];
            next[0]=1;
            for (int j = 1; j <= n; j++){
                next[j]=dp[j];
                if (s.charAt(i-1)==t.charAt(j-1)){
                    next[j]+=dp[j-1];
                }
            }
            dp=next;
        }
        return dp[n];
    }
}

class Solution {
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();
        int[] dp = new int[m+1];
        Arrays.fill(dp, 1);
        for (int i = 1; i <= n; i++){
            int prev = dp[0];
            dp[0]=0;
            for (int j = 1; j <= m; j++){
                int cur = dp[j];
                dp[j]=dp[j-1];
                if (s.charAt(j-1)==t.charAt(i-1)){
                    dp[j]+=prev;
                }
                prev=cur;
            }
        }
        return dp[m];
    }
}

class Solution {
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();
        int[] dp = new int[m+1];
        Arrays.fill(dp, 1);
        for (int i = 1; i <= n; i++){
            int[] next = new int[m+1];
            for (int j = 1; j <= m; j++){
                next[j]=next[j-1];
                if (s.charAt(j-1)==t.charAt(i-1)){
                    next[j]+=dp[j-1];
                }
            }
            dp=next;
        }
        return dp[m];
    }
}

class Solution {
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();
        int[][] dp = new int[m+1][n+1];
        for (int i = 0; i <= m; i++){
            dp[i][0]=1;
        }
        for (int i = 1; i <= m; i++){
            for (int j = 1; j <= n; j++){
                dp[i][j]=dp[i-1][j];
                if (s.charAt(i-1)==t.charAt(j-1)){
                    dp[i][j]+=dp[i-1][j-1];
                }
            }
        }
        return dp[m][n];
    }
}

class Solution {
    public int numDistinct(String s, String t) {
        List<Integer>[] letters = new ArrayList[128];
        Arrays.setAll(letters, o -> new ArrayList<>());
        for (int i = 0; i < s.length(); i++){
            letters[s.charAt(i)].add(i);
        }
        int[] dp = new int[s.length()];
        for (int idx : letters[t.charAt(0)]){
            dp[idx] = 1;
        }
        for (int i = 1; i < t.length(); i++){
            int j = 0, k = 0;
            int[] next = new int[s.length()];
            List<Integer> cur = letters[t.charAt(i)];
            List<Integer> prev= letters[t.charAt(i-1)];
            for (; j < cur.size(); j++){
                next[cur.get(j)] = j == 0? 0 : next[cur.get(j-1)];
                for (; k < prev.size() && prev.get(k) < cur.get(j); k++){
                    next[cur.get(j)] += dp[prev.get(k)];
                }
            }
            dp = next;
        }
        return Arrays.stream(dp).sum();
    }
}
