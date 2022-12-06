class Solution {
    public int countNicePairs(int[] nums) {
        int ans = 0, m = (int)1e9 + 7;
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums){
            int sum = n - rev(n);
            ans = (ans + map.getOrDefault(sum, 0)) % m;
            map.merge(sum, 1, Integer::sum);
        }

        return ans;
    }

    private int rev(int n){
        int ans = 0;
        while(n > 0){
            ans = 10 * ans + n % 10;
            n /= 10;
        }

        return ans;
    }
}
