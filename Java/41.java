class Solution {
    public int firstMissingPositive(int[] nums) {
        int PRESENT = (int)1e6;
        for (int i = 0; i < nums.length; i++){
            if (nums[i]==PRESENT){
                nums[i]=0;
            }
        }
        for (int i = 0; i < nums.length; i++){
            int j = nums[i];
            while(j > 0 && j <= nums.length){
                int next = nums[j-1];
                nums[j-1]=PRESENT;
                j = next;
            }
        }
        int ans = 1;
        while(ans<=nums.length && nums[ans-1]==PRESENT){
            ans++;
        }
        return ans;
    }
}
// class Solution {
//     public int firstMissingPositive(int[] nums) {
//         int ans = 1, n = nums.length;
//         for (int i = 0; i < n; i++){
//             if (nums[i]<0||nums[i]>n){
//                 nums[i]=0;
//             }
//         }
//         for (int i = 0; i < n; i++){
//             int cur = nums[i]%(n+1);
//             if (cur>0){
//                 nums[cur-1]+=(n+1);
//             }
//         }
//         while(ans <= n && nums[ans-1]>n){
//             ans++;
//         }
//         return ans;
//     }
// }
// class Solution {
//     public int firstMissingPositive(int[] nums) {
//         int PRESENT = (int)1e6;
//         for (int i = 0; i < nums.length; i++){
//             int j = nums[i];
//             while(j > 0 && j <= nums.length){
//                 int next = nums[j-1];
//                 nums[j-1]=PRESENT;
//                 j = next;
//             }
//         }
//         int ans = 1;
//         while(ans<=nums.length && nums[ans-1]==PRESENT){
//             ans++;
//         }
//         return ans;
//     }
// }
