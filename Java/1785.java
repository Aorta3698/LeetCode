class Solution {
    public int minElements(int[] nums, int limit, int goal) {
        long g = 0L + goal - Arrays.stream(nums).asLongStream().sum();
        g = Math.abs(g);
        return (int)(g/limit) + (g % limit > 0? 1 : 0);
    }
}
