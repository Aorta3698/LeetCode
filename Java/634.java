class Solution {
    public int findDerangement(int n) {
        if (n == 1)
            return 0;

        int m = (int)1e9 + 7;
        long prev = 0, cur = 1;
        for (int i = 2; i < n; i++){
            long tmp = prev;
            prev = cur;
            cur = i * (tmp + prev) % m;
        }
        return (int)cur;
    }
}
