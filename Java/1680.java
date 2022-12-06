class Solution {
    public int concatenatedBinary(int n) {
        int m = (int)1e9 + 7, ans = 0;
        for (int i = n, cur = 1; i >= 1; i--){
            for (int j = i; j > 0; j >>= 1){
                if ((j & 1) > 0){
                    ans = (ans + cur) % m;
                }
                cur = (cur << 1) % m;
            }
        }
        return ans;
    }
}
