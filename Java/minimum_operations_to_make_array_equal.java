class Solution {
    public int minOperations(int n) {
        return (n / 2 * (n + n % 2)) / 2;
        // return n % 2 == 1? n / 2 * (2 + (n - 1)) / 2 : (n / 2 * n) / 2;
    }
}
