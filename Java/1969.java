https://leetcode.com/problems/minimum-non-zero-product-of-the-array-elements/discuss/1993640/Java-Concise-Iterative-Sol-0ms
class Solution {
    public int minNonZeroProduct(int p) {
        int m = (int)(1e9 + 7);
        long n = ((1L << p) - 2) % m, ans = n + 1, cnt = (1L << (p - 1)) - 1;
        while(cnt > 0){
            if ((cnt & 1) == 1){
                ans = ans * n % m;
            }
            cnt >>= 1;
            n = n * n % m;
        }
        return (int)ans;
    }
}
