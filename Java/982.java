class Solution {
    public int countTriplets(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for (int n : nums){
            for (int m : nums){
                map.merge(n & m, 1, Integer::sum);
                max = Math.max(n & m, max);
            }
        }
        for (int i = 0; (1 << i) < max; i++){
            max |= (1 << i);
        }

        int ans = 0;
        for (int n : nums){
            for (int i = max & ~n; ; i = (i - 1) & ~n){
                ans += map.getOrDefault(i, 0);
                if (i == 0) break;
            }
        }

        return ans;
    }
}
