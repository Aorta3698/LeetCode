https://leetcode.com/problems/special-array-with-x-elements-greater-than-or-equal-x/discuss/1638624/Java-counting-sort-with-suffix-sum-with-comments-(5-lines).
class Solution {
    public int specialArray(int[] nums) {
        int[] count = new int[1001];
        for (int n : nums) ++count[n];
        for (int i = 999; i >= 0; i--) count[i] += count[i + 1];
        for (int i = 0; i < 1001; i++)
            if (count[i] == i)
                return i;
        return -1;
    }
}
