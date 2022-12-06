class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        Integer[] copy = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++){
            copy[i] = nums[i];
        }
        Arrays.sort(copy, Comparator.comparingInt(o -> get(mapping, o)));
        for (int i = 0; i < nums.length; i++){
            nums[i] = copy[i];
        }
        return nums;
    }

    private int get(int[] mapping, int n){
        int i = 1, ret = 0;
        while(10 * i <= n) i *= 10;
        while(i > 0){
            int d = n / i;
            ret = 10 * ret + mapping[d];
            n -= d * i;
            i /= 10;
        }
        return ret;
    }
}
