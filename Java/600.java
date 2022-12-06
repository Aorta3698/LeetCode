https://leetcode.com/problems/non-negative-integers-without-consecutive-ones/discuss/2308001/Java-or-DP-on-Number
class Solution {
    public int findIntegers(int n) {
        // 1101001
        // 1001010
        ++n;
        int[][] dp = new int[30][2];
        dp[1][1]=dp[1][0]=1;
        for (int i = 2; i < 30; i++){
            dp[i][1]=dp[i-1][0];
            dp[i][0]=dp[i-1][0]+dp[i-1][1];
        }
        List<Integer> list = new ArrayList<>();
        while(n > 0){
            list.add(n % 2);
            n /= 2;
        }
        int ans = 0;
        for (int i = 1; i < list.size(); i++){
            ans += add(i-2, dp); // 10XXXXX
        }
        for (int i = list.size() - 1; i > 0; --i){
            if (list.get(i-1) == 1){
                ans += add(i-1, dp); // 100100 -> 1000XX
                if (list.get(i) == 1){
                    break;
                }
            }
        }
        return ans;
    }

    private int add(int len, int[][] dp){
        return switch(len){
            case -2 : yield 0;
            case -1 : yield 2;
            case  0 : yield 1;
            default : yield dp[len][0]+dp[len][1];
        };
    }
}

class Solution {
    public int findIntegers(int n) {
        // 1101001
        // 1001010
        if (n == 1){
            return 2;
        }
        int[][] dp = new int[30][2];
        dp[1][1]=dp[1][0]=1;
        for (int i = 2; i < 30; i++){
            dp[i][1]=dp[i-1][0];
            dp[i][0]=dp[i-1][0]+dp[i-1][1];
        }
        List<Integer> list = new ArrayList<>();
        while(n > 0){
            list.add(n % 2);
            n /= 2;
        }
        int ans = 0;
        for (int i = 1; i < list.size(); i++){
            ans += add(i-2, dp); // 10XXXXX
        }
        boolean ok = true;
        for (int i = list.size() - 1; i > 0 && ok; --i){
            if (list.get(i-1) == 1){
                ans += add(i-1, dp); // 100100 -> 1000XX
                ok &= list.get(i)==0;
            }
        }
        return ok?1+ans:ans;
    }

    private int add(int len, int[][] dp){
        return switch(len){
            case -2 : yield 0;
            case -1 : yield 2;
            case  0 : yield 1;
            default : yield dp[len][0]+dp[len][1];
        };
    }
}
