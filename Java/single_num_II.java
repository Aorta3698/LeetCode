class Solution {
    public int singleNumber(int[] nums) {
        long s = 0;
        Set<Long> set = new HashSet<>();
        for (int i : nums){
            set.add((long)i);
            s += i;
        }

        long sum = 0;
        for (Long l : set)
            sum+=l;

        return (int)((3*sum-s)/2);

    }
}
