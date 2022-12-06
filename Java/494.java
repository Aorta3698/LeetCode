https://leetcode.com/problems/target-sum/discuss/2431992/Java-or-Short-Bottom-up-DP
class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        var dp = new HashMap<Integer, Integer>();
        dp.put(0, 1);
        for (int n : nums){
            var ndp = new HashMap<Integer, Integer>();
            for (int key : dp.keySet()){
                ndp.merge(key-n, dp.get(key), Integer::sum);
                ndp.merge(key+n, dp.get(key), Integer::sum);
            }
            dp=ndp;
        }
        return dp.getOrDefault(target, 0);
    }
}
