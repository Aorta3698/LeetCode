class Solution {
    public int sumOfBeauties(int[] nums) {
        int[] left = new int[nums.length];
        int[] right= new int[nums.length];
        right[nums.length - 1] = nums.length - 1;
        for (int i = 0; i < nums.length; i++){
            int j = nums.length - 1 - i;
            if (i > 0){
                left[i] = nums[i] > nums[left[i - 1]]? i : left[i - 1];
                right[j] = nums[j] < nums[right[j + 1]]? j : right[j + 1];
            }
        }
        int ans = 0;
        for (int i = 1; i < nums.length - 1; i++){
            if (left[i] == i && right[i] == i){
                ans += 2;
            }else if (nums[i] > nums[i - 1] && nums[i] < nums[i + 1]){
                ans++;
            }
        }

        return ans;
    }
}
