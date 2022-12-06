class Solution {
    public long maxAlternatingSum(int[] nums) {
        long ans = nums[0];
        for (int i = 1; i < nums.length; i++){
            ans += Math.max(0, nums[i] - nums[i - 1]);
        }

        return ans;
    }
}
// class Solution {
//     public long maxAlternatingSum(int[] nums) {
//         long ans = nums[0], turn = 1, sum = ans;
//         for (int i = 1; i < nums.length; i++){
//             int d = nums[i] - nums[i - 1];
//             if (d > 0){
//                 sum += turn == 0? nums[i] : d;
//                 turn = 1;
//             }else{
//                 sum -= turn == 1? nums[i] : d;
//                 turn = 0;
//             }
//             ans = Math.max(ans, sum);
//         }

//         return ans;
//     }
// }
