class Solution {
    public int findFinalValue(int[] nums, int original) {
        boolean[] d = new boolean[2*1001];
        for (int n : nums) d[n] = true;
        while(d[original]) original <<= 1;
        return original;
    }
}
