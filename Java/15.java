class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++){
            if (i == 0 || nums[i] != nums[i - 1]){
                twoSum(i + 1, -nums[i], nums, ans);
            }
        }
        return ans;
    }

    private void twoSum(int st, int target, int[] nums, List<List<Integer>> ans){
        int lo = st, hi = nums.length - 1;
        while(lo < hi){
            int sum = nums[lo] + nums[hi];
            if (sum > target){
                hi--;
            }else if (sum < target){
                lo++;
            }else{
                ans.add(List.of(nums[st - 1], nums[lo++], nums[hi--]));
                while(lo < hi && nums[lo] == nums[lo - 1]){
                    lo++;
                }
                while(hi > lo && nums[hi] == nums[hi + 1]){
                    hi--;
                }
            }
        }
    }
}

// class Solution {
//     public List<List<Integer>> threeSum(int[] nums) {
//         Arrays.sort(nums);
//         List<List<Integer>> ans = new ArrayList<>();
//         for (int i = 0; i < nums.length; i++){
//             if (i == 0 || nums[i] != nums[i - 1]){
//                 twoSum(i + 1, -nums[i], nums, ans);
//             }
//         }
//         return ans;
//     }

//     private void twoSum(int st, int target, int[] nums, List<List<Integer>> ans){
//         Set<Integer> seen = new HashSet<>();
//         for (int i = st; i < nums.length; i++){
//             if (seen.contains(target - nums[i])){
//                 ans.add(List.of(nums[st - 1], target-nums[i], nums[i]));
//                 while(i < nums.length - 1 && nums[i] == nums[i + 1]){
//                     ++i;
//                 }
//             }
//             seen.add(nums[i]);
//         }
//     }
// }
