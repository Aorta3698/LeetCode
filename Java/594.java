class Solution {
    public int findLHS(int[] nums) {
        int ans = 0;
        Map<Integer, Integer> count = new HashMap<>();
        for (int n : nums){
            count.merge(n, 1, Integer::sum);
            if (count.containsKey(n - 1)) ans = Math.max(count.get(n) + count.get(n - 1), ans);
            if (count.containsKey(n + 1)) ans = Math.max(count.get(n) + count.get(n + 1), ans);
        }

        return ans;
    }
}
