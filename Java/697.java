class Solution {
    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> idx = new HashMap<>(), count = new HashMap<>();
        int n = nums.length, ans = n, max = 0;
        for (int i = 0; i < n; ++i){
            int j = nums[i];
            idx.putIfAbsent(j, i);

            if (count.merge(j, 1, Integer::sum) == max){
                ans = Math.min(i - idx.get(j) + 1, ans);
            }
            else if (count.get(j) > max){
                max = count.get(j);
                ans = i - idx.get(j) + 1;
            }
        }

        return ans;

        // ANOTHER SOLUTION BUT IT IS SLOWER:

        // int n = nums.length, max = 0, ans = n;
        // int[][] count = new int[50000][2];
        // for (int i = 0; i < n; i++){
        //     if (count[nums[i]][1] == 0) count[nums[i]][1] = i + 1;

        //     int c = ++count[nums[i]][0], p = count[nums[i]][1] - 1;
        //     if (c == max) ans = Math.min(i - p + 1, ans);
        //     if (c > max){
        //         max = c;
        //         ans = i - p + 1;
        //     }
        // }

        // return ans;
    }
}
