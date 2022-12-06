https://leetcode.com/problems/check-if-an-array-is-consecutive/discuss/1920777/Java-or-9ms-with-BitSet
class Solution {
    public boolean isConsecutive(int[] nums) {
        BitSet bit = new BitSet();
        int min = Integer.MAX_VALUE, max = 0;
        for (int n : nums){
            bit.set(n);
            min = Math.min(min, n);
            max = Math.max(max, n);
        }
        return max - min + 1 == nums.length && bit.get(min, max).cardinality() == max - min;
    }
}
