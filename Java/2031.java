class Solution {
    public int subarraysWithMoreZerosThanOnes(int[] nums) {
        int ans = 0, score = 0, n = nums.length, m = (int)1e9+7;
        int[] dp = new int[2];
        int[] count = new int[2*n+1];
        count[n]++;
        for (int i = 0; i < n; i++){
            int[] save = dp.clone();
            score += (nums[i] == 0? -1 : 1);
            dp[0] = count[score + n];
            if (nums[i] == 1){
                dp[1] = save[1] + save[0] + 1;
            }else{
                dp[1] = save[1] - count[score + n];
            }
            count[score + n]++;
            ans = (ans + dp[1]) % m;
        }
        return ans;
    }
}
// THE SOLUTION BELOW IS QUICKER BUT LONGER

// class Solution {
//     public int subarraysWithMoreZerosThanOnes(int[] nums) {
//         int n = nums.length, score = 0, m = (int)1e9 + 7, ans = 0;
//         int max = 0, min = 0;
//         for (int i = 0; i < n; i++){
//             score += (nums[i] == 0? -1 : 1);
//             max = Math.max(max, score);
//             min = Math.min(min, score);
//         }

//         int[] data = new int[max - min + 1];
//         score = -min;
//         update(score, 1, data);

//         for (int i = 0; i < n; i++){
//             score += (nums[i] == 0? -1 : 1);
//             ans = (ans + sumRange(0, score - 1, data)) % m;
//             update(score, 1, data);
//         }

//         // int[] data = new int[2*n + 1];
//         // for (int i = 0; i < n; i++){
//         //     score += (nums[i] == 0? -1 : 1);
//         //     ans = (ans + sumRange(0, score - 1, data)) % m;
//         //     update(score, 1, data);
//         //     if (score > n) ans++;
//         // }

//         return ans;
//     }

//     public void update(int index, int add, int[] data) {
//         index++;
//         while(index < data.length){
//             data[index] += add;
//             index += index & -index;
//         }
//     }

//     public int sumRange(int left, int right, int[] data) {
//         return getSum(right, data) - getSum(--left, data);
//     }

//     private int getSum(int index, int[] data){
//         int ans = 0;
//         ++index;
//         while(index > 0){
//             ans += data[index];
//             index -= index & -index;
//         }

//         return ans;
//     }
// }
