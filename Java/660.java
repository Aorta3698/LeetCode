class Solution {
    public int newInteger(int n) {
        long lo = 0, hi = (long)1e10;
        while(lo < hi){
            long mid = (lo+hi)>>1;
            if (find(mid)>=n){
                hi=mid;
            }else{
                lo=mid+1;
            }
        }
        return (int)lo;
    }

    private long find(long n){
        String s = ""+n;
        int[][] dp = new int[s.length()+1][2];
        dp[s.length()][0]=1;
        long count = 0;
        for (int i = s.length()-1; i >= 0; i--){
            for (int j = 8; j >= 0; j--){
                for (int t : new int[]{0, 1}){
                    int nt = t;
                    if (j > s.charAt(i)-'0'){
                        nt=1;
                    }else if (j < s.charAt(i) - '0'){
                        nt=0;
                    }
                    dp[i][nt] += dp[i+1][t];
                }
                if (j == 1){
                    count += dp[i][0];
                    count += (i==0? 0 : dp[i][1]);
                }
            }
        }
        return count;
    }
}
