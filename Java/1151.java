class Solution {
    public int minSwaps(int[] data) {
        int len = Arrays.stream(data).sum(), ans = Integer.MAX_VALUE;
        for (int i = 0, zero = 0; i < data.length; i++){
            if (i == len) ans = zero;
            if (i < len) zero += 1 - data[i];
            else {
                zero += 1 - data[i] - 1 + data[i - len];
                ans = Math.min(zero, ans);
            }
        }

        return ans == Integer.MAX_VALUE? 0 : ans;
    }
}
