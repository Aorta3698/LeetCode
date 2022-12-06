https://leetcode.com/problems/matchsticks-to-square/discuss/2270472/Java-or-1D-DP-bottom-up-or-66ms-or-Explained.
class Solution {
    public boolean makesquare(int[] matchsticks) {
        int sum = Arrays.stream(matchsticks).sum(), N = matchsticks.length;
        if (sum % 4 != 0){
            return false;
        }
        sum/=4;
        int[] got = new int[1<<N];
        boolean[] dp = new boolean[1<<N];
        List<Integer> ok = new ArrayList<>();
        for (int i = 0; i < N; i++){
            got[1<<i]=matchsticks[i];
        }
        for (int i = 1; i < 1<<N; i++){
            got[i]=got[i&-i]+got[i&(i-1)];
            if (got[i]==sum){
                for (int m : ok){
                    if ((m&i)==0){
                        dp[m|=i]=true;
                        if (dp[m^((1<<N)-1)]){
                            return true;
                        }
                    }
                }
                ok.add(i);
            }
        }
        return false;
    }
}

class Solution {
    public boolean makesquare(int[] A) {
        long sum = Arrays.stream(A).asLongStream().sum();
        if (sum % 4 > 0){
            return false;
        }

        Integer[] dp = new Integer[1 << A.length];
        find(A, 0, dp, (int)(sum >> 2), 0, 0);

        return dp[(1 << A.length) - 1] != null && dp[(1 << A.length) - 1] == 4;
    }

    private int find(int[] A, int used, Integer[] dp, int target, int sum, int time){
        if (sum == target){
            if (++time == 4){
                return dp[used] = 4;
            }
            sum = 0;
        }
        if (dp[used] != null){
            return dp[used];
        }

        for (int i = 0; i < A.length; i++){
            if (((1 << i) & used) > 0 || sum + A[i] > target){
                continue;
            }
            if (find(A, used | (1 << i), dp, target, sum + A[i], time) == 4){
                return dp[used] = 4;
            }
        }

        return dp[used] = time;
    }
}
