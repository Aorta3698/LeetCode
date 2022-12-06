class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = Arrays.stream(nums).sum(), target = sum/k, n=nums.length;
        if (sum % k != 0){
            return false;
        }
        int[] s = new int[1<<n];
        for (int i = 1; i < 1<<n; i++){
            s[i]=(int)1e9;
            for (int j = 0; j < n && s[i]>0; j++){
                if ((i & 1 << j) > 0){
                    int cur = s[i^1<<j]+nums[j];
                    s[i]=Math.min(s[i], cur==target?0 : cur);
                }
            }
        }
        return s[(1<<n)-1]==0;
    }
}

// class Solution {
//     public boolean canPartitionKSubsets(int[] nums, int k) {
//         int x = 1 << nums.length, sum = Arrays.stream(nums).sum();
//         if (sum % k > 0 || nums.length < k){
//             return false;
//         }
//         Arrays.sort(nums);
//         if (nums[nums.length - 1] > sum / k){
//             return false;
//         }

//         Integer[] dp = new Integer[x];
//         find(nums, dp, sum / k, 0, 0, k);

//         return dp[x - 1] != null && dp[x - 1] == 0;
//     }

//     private int find(int[] nums, Integer[] dp, int target, int sum, int mask, int k){
//         if (dp[mask] != null){
//             return dp[mask];
//         }
//         if (sum == target){
//             if (--k == 0){
//                 return dp[mask] = 0;
//             }
//             sum = 0;
//         }

//         for (int i = 0; i < nums.length; i++){
//             if (((1 << i) & mask) > 0){
//                 continue;
//             }
//             if (nums[i] + sum > target){
//                 break;
//             }
//             if (find(nums, dp, target, sum + nums[i], mask | (1 << i), k) == 0){
//                 return dp[mask] = 0;
//             }
//         }

//         return dp[mask] = k;
//     }
// }
