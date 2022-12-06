import java.math.BigInteger;
class Solution {
    public int numberOfSets(int n, int k) {
        BigInteger ans = BigInteger.ONE;
        for (int i = 0; i < n - k - 1; i++){
            ans = ans.multiply(BigInteger.valueOf(n + k - 1 - i));
            ans = ans.divide(BigInteger.valueOf(i + 1));
        }

        return ans.mod(BigInteger.valueOf((int)1e9 + 7)).intValue();
    }
}
