class Solution {
    public boolean divisorGame(int n) {
        //f(10) -> f(10 - 1), f(10 - 2), f(10 - 5).
        //Choose the one that guarantees lose if you were to start with that number
        //in other words, for f(10) to be true, one of the 3 has to be false.
        boolean[] dp = new boolean[n + 1];
        // dp[1] = false; base case.
        for (int i = 2; i < dp.length; i++){
            for (int j = 1; j <= i / 2; j++){
                if (i % j == 0 && !dp[i - j]){
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[dp.length - 1];
    }
}
