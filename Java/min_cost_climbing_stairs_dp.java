class Solution {
    public int minCostClimbingStairs(int[] cost) {
        //f(n) = Min(f(n - 2) + cost[n - 2], f(n - 1) + cost[n - 1])
        int[] min = new int[cost.length + 1];

        for(int i = 2; i < min.length; i++)
            min[i] = Math.min(min[i - 2] + cost[i - 2], min[i - 1] + cost[i - 1]);

        return min[min.length - 1];
    }
}
