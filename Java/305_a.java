class Solution {
    public int longestIdealString(String s, int k) {
        int[][] dp = new int[s.length()][2];
        int[] last = new int[26];
        Arrays.fill(last, -1);
        for (int i = 0; i < s.length(); i++){
            dp[i][0]=i==0?0:Math.max(dp[i-1][0],dp[i-1][1]);
            dp[i][1]=1;
            int cur = s.charAt(i)-'a';
            for (int j = Math.max(0, cur-k); j <= Math.min(25, cur+k); j++){
                if (last[j]!=-1){
                    dp[i][1]=Math.max(dp[i][1], dp[last[j]][1]+1);
                }
            }
            last[cur]=i;
        }

        return Math.max(dp[s.length()-1][0], dp[s.length()-1][1]);
    }
}
