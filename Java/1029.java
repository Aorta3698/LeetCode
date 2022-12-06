class Solution {
    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, Comparator.comparingInt(o -> o[0] - o[1]));
        int ans = 0;
        for (int i = 0; i < costs.length; i++){
            ans += costs[i][2 * i / costs.length];
        }

        return ans;
    }
}
