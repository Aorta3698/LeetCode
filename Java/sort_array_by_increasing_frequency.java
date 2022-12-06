class Solution {
    public int[] frequencySort(int[] nums) {
        int[] count = new int[201];
        Integer[] copy = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            copy[i] = nums[i];
            count[nums[i] + 100]++;
        }

        Comparator<Integer> cmp = (a, b) -> {
            return count[a + 100] == count[b + 100]?
                b - a : count[a + 100] - count[b + 100];
        };
        Arrays.sort(copy, cmp);
        for (int i = 0; i < nums.length; i++) nums[i] = copy[i];
        return nums;
    }
}
