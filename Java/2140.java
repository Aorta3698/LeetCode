class Solution {
    public long mostPoints(int[][] questions) {
        Long[] memo = new Long[questions.length];
        return solve(0, questions, memo);
    }

    private long solve(int idx, int[][] q, Long[] memo){
        if (idx >= q.length) return 0;
        if (memo[idx] != null) return memo[idx];

        long take = q[idx][0] + solve(idx + q[idx][1] + 1, q, memo);
        long skip = solve(idx + 1, q, memo);

        return memo[idx] = Math.max(take, skip);
    }
}
