class Solution {
    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = 0, m = (int)1e9 + 7, n = nums.length;

        int[] pow = new int[n];
        pow[0] = 1;
        for (int i = 1; i < n; i++){
            pow[i] = (pow[i - 1] * 2) % m;
        }

        for (int i = 0, j = n - 1; i < n && j >= i; i++){
            while(j >= 0 && nums[i] + nums[j] > target){
                --j;
            }

            if (j >= i){
                // 1 + 1 + 2 + ... + 2^(j - i - 1) = 2 ^ (j - i);
                // ans = (ans + (1 << (j - i))) % m;
                ans = (ans + pow[j - i]) % m;
            }
        }

        return ans;
    }
}
// import java.math.BigInteger;

// class Solution {
//     public int numSubseq(int[] nums, int target) {
//         Arrays.sort(nums);
//         int m = (int)1e9 + 7, n = nums.length;
//         BigInteger bm = BigInteger.valueOf(m);
//         BigInteger ans = BigInteger.valueOf(0);

//         for (int i = 0, j = n - 1; i < n; i++){
//             while(j >= 0 && nums[i] + nums[j] > target){
//                 --j;
//             }
//             if (j < i){
//                 break;
//             }

//             ans = ans.add(BigInteger.ONE.shiftLeft(j - i));

//             // 1 + 1 + 2 + ... + 2^(j - i - 1) = 2 ^ (j - i);
//             // ans = (ans + (1 << (j - i))) % m; // Hmmm
//         }

//         return ans.mod(bm).intValue();
//     }
// }
