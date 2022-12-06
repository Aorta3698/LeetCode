class Solution {
    public int[] decrypt(int[] code, int k) {
        int n = code.length, sum = 0, idx = (n + Integer.signum(k)) % n;
        for (int i = 0; i < Math.abs(k); i++, idx += Integer.signum(k)) sum += code[idx];
        int[] ans = new int[n];
        for (idx = 0; idx < n; idx++){
            ans[idx] = sum;
            int add = k < 0? idx : (idx + k + 1) % n;
            int sub = k < 0? (idx + n + k) % n : (idx + 1) % n;
            sum += code[add] - code[sub];
        }

        return ans;
    }
}
