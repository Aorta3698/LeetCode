class Solution {
    public int largestUniqueNumber(int[] nums) {
        int[] count = new int[1001];
        for (int n : nums) count[n]++;
        for (int i = count.length - 1; i >= 0; i--)
            if (count[i] == 1)
                return i;
        return -1;
    }
}
