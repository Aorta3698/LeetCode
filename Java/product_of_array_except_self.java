class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];
        int p = 1;
        int zeroIdx = -1;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] == 0){
                if (zeroIdx != -1) return ans;
                zeroIdx = i;
                continue;
            }
            p *= nums[i];
        }

        if (zeroIdx != -1) {ans[zeroIdx] = p; return ans;}
        for (int i = 0; i < nums.length; i++) ans[i] = div(p, nums[i]);

        return ans;
    }

    private int div(int p, int d){
        int sign = 0;
        if (p < 0) {sign++; p = -p;}
        if (d < 0) {sign++; d = -d;}
        int re = 0;
        int n = 1;
        while(p > d *(n << 1)) n <<= 1;
        while(p > 0){
            re += n;
            p -= d * n;
            while(p < d * n) n >>= 1;
        }

        return sign == 1? -re : re;
    }
}
