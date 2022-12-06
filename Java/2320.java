https://leetcode.com/problems/count-number-of-ways-to-place-houses/discuss/2207469/Java-or-2-Solutions
class Solution {
    public int countHousePlacements(int n) {
        int M = (int)1e9+7;
        int[] dp = new int[4];
        dp[0]=1;
        for (int i = 0; i < n; i++){
            int[] next = new int[4];
            for (int j = 0; j < 4; j++){
                for (int k = 0; k < 4; k++){
                    if ((j&k)==0){
                        next[j] = (next[j] + dp[k]) % M;
                    }
                }
            }
            dp=next;
        }
        return (int)(Arrays.stream(dp).asLongStream().sum()%M);
    }
}

class Solution {
    public int countHousePlacements(int n) {
        int M = (int)1e9+7;
        long a = 1, b = 1;
        for (int i = 0; i < n; i++){
            b = (b + a) % M;
            a = (b - a + M) % M;
        }
        return (int)(b*b%M);
    }
}
