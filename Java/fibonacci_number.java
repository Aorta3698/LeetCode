class Solution {
    public int fib(int n) {
        int[] f = new int[]{0, 1, 1};
        for (int i = 2; i < n; i++){
            f[0] = f[1];
            f[1] = f[2];
            f[2] = f[0] + f[1];
        }

        return n == 0? 0 : f[2];
    }
}
