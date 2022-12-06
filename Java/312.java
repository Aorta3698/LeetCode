class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        return find(nums, 0, n - 1, new int[n][n]);
        // int max = 0, n = nums.length;
        // for (int i = 0; i < n; i++){
        //     int l = i > 0? nums[i - 1] : 1;
        //     int r = i < n - 1? nums[i + 1] : 1;
        //     int score = nums[i] * l * r;
        //     // int[] copy = new int[n - 1];
        //     // System.arraycopy(nums, 0, copy, 0, i);
        //     // System.arraycopy(nums, i + 1, copy, i, n - i - 1);
        //     max = Math.max(score + maxCoins(copy), max);
        // }

        // return max;
    }

    private int find(int[] nums, int lo, int hi, int[][] memo){
        if (lo > hi) return 0;
        if (memo[lo][hi] != 0) return memo[lo][hi];

        int max = 0;
        for (int i = lo; i <= hi; i++){
            int l = lo == 0? 1 : nums[lo - 1];
            int r = hi == nums.length - 1? 1 : nums[hi + 1];
            int score = l * r * nums[i];
            max = Math.max(score + find(nums, lo, i - 1, memo) + find(nums, i + 1, hi, memo), max);
        }

        return memo[lo][hi] = max;
    }

    // Map<Integer, Integer> map = new HashMap<>();
    // private int find(int[] nums, boolean[] visited){
    //     int key = visited.hashCode();
    //     if (map.containsKey(key)) {
    //         return map.get(key);
    //     }

    //     int max = 0, n = nums.length;
    //     for (int i = 0, prev = -1; i < n; i++){
    //         if (!visited[i]){
    //             int l = prev > -1? nums[prev] : 1;

    //             int j = i + 1;
    //             for (; j < n && visited[j]; j++);

    //             int r = j < n? nums[j] : 1;

    //             visited[i] = true;
    //             int score = find(nums, visited);
    //             score += nums[i] * l * r;
    //             max = Math.max(score, max);
    //             visited[i] = false;
    //             prev = i;
    //         }
    //     }

    //     map.put(visited.hashCode(), max);
    //     return max;
    // }
}
