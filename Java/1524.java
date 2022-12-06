class Solution {
    public int numOfSubarrays(int[] arr) {
        int odd = 0, even = 1, pre = 0, ans = 0, m = (int)1e9+7;
        for (int n : arr){
            pre += (n & 1);
            if ((pre & 1) == 1){
                ans = (ans + even) % m;
                ++odd;
            }else{
                ans = (ans + odd) % m;
                ++even;
            }
        }
        return ans;
    }
}
