class Solution {
    public int minOperations(int[] nums, int x) {
        int target = Arrays.stream(nums).sum()-x, ans = -1;
        for (int i = 0, j = 0, sum = 0; i < nums.length; i++){
            sum += nums[i];
            while(j <= i && sum > target){
                sum -= nums[j++];
            }
            if (sum == target){
                ans = Math.max(i-j+1, ans);
            }
        }
        return ans == -1? -1 : nums.length - ans;
    }
}
// class Solution {
//     public int minOperations(int[] nums, int x) {
//         int sum = Arrays.stream(nums).sum(), pre = 0, ans = Integer.MAX_VALUE;
//         Map<Integer, Integer> map = new HashMap<>();
//         map.put(0, -1);
//         for (int i = 0; i < nums.length; i++){
//             pre += nums[i];
//             map.putIfAbsent(pre, i);
//             if (map.containsKey(pre+x-sum)){
//                 ans = Math.min(ans, nums.length - (i - map.get(pre+x-sum)));
//             }
//         }
//         return ans == Integer.MAX_VALUE? -1 : ans;
//     }
// }
