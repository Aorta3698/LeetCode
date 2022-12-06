https://leetcode.com/problems/count-array-pairs-divisible-by-k/discuss/2348080/GCD-or-Java-or-Kind-of-Similar-to-2344.-Minimum-Deletions-to-Make-Array-Divisible
class Solution {
    public long countPairs(int[] nums, int k) {
        int[] map = new int[100001];
        long ans = 0;
        for (int n : nums){
            int w = k / gcd(k, n);
            for (int i = 1; i*i <= n; i++){
                if (n % i == 0){
                    map[i]++;
                    if (i*i!=n){
                        map[n/i]++;
                    }
                }
            }
            ans += map[w] - (n % w == 0? 1 : 0);
        }
        return ans;
    }

    private int gcd(int a, int b){
        return a == 0? b : gcd(b%a, a);
    }
}
