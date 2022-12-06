https://leetcode.com/problems/minimum-cost-of-buying-candies-with-discount/discuss/1710807/Java-or-Simple-Greedy-or-Brief-Explanation
class Solution {
    public int minimumCost(int[] cost) {
        Arrays.sort(cost);
        int ans = 0;
        for (int i = cost.length - 1; i >= 0; i--){
            if (i % 3 == cost.length % 3) continue;
            ans += cost[i];
        }

        return ans;
    }
}
