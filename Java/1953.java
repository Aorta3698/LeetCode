https://leetcode.com/problems/maximum-number-of-weeks-for-which-you-can-work/discuss/1990068/Java-Check-Max-against-Rest
class Solution {
    public long numberOfWeeks(int[] milestones) {
        long sum = 0;
        long max = 0;
        for (int m : milestones){
            sum += m;
            max = Math.max(max, m);
        }
        return sum - max + 1 >= max? sum : 1 + 2 * (sum - max);
    }
}
