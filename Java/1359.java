class Solution {
    public int countOrders(int n) {
        // dp_1 = 1
        // dp_2 * (1 + 2 + 3)
        // dp_3 * (1 + 2 + ... + 5)
        long ans = 1;
        for (int i = 2; i <= n; i++){
            ans *= (2*i-1)*i;
            ans %= (int)(1e9+7);
        }
        return (int)ans;
    }
}
