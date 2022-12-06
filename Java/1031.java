class Solution {
    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        int ans = 0, a = 0, b = 0, n = nums.length;
        int[] line = new int[n + 1];
        int[] data = new int[n + 1];
        for (int i = n - 1; i >= 0; i--){
            b += nums[i];
            if (i <= n - 1 - secondLen){
                b -= nums[i + secondLen];
            }
            if (i <= n - secondLen){
                line[i] = Math.max(line[i + 1], b);
                data[i] = b;
            }
        }

        int pre = 0;
        for (int i = 0, j = 0; i < nums.length; i++){
            a += nums[i];
            if (i >= firstLen){
                a -= nums[i - firstLen];
            }
            if (i - firstLen + 1 > secondLen - 1){
                pre = Math.max(pre, data[j++]);
            }
            if (i >= firstLen - 1){
                ans = Math.max(Math.max(line[i + 1], pre) + a, ans);
            }
        }

        return ans;
    }
}
