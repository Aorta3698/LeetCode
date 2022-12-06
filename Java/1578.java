https://leetcode.com/problems/minimum-time-to-make-rope-colorful/discuss/1890884/Java-or-Find-Max-Element
class Solution {
    public int minCost(String colors, int[] neededTime) {
        int ans = 0, sum = 0, max = 0;
        for (int i = 0; i < colors.length(); i++){
            max = Math.max(max, neededTime[i]);
            sum += neededTime[i];
            if (i == colors.length() - 1 || colors.charAt(i) != colors.charAt(i + 1)){
                ans += sum - max;
                sum = max = 0;
            }
        }
        return ans;
    }
}
