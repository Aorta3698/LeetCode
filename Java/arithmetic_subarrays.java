class Solution {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> ans = new ArrayList<>();
        for (int i = 0; i < l.length; i++)
            ans.add(check(Arrays.copyOfRange(nums, l[i], r[i] + 1)));

        return ans;
    }

    private boolean check(int[] nums){
        Arrays.sort(nums);
        for (int i = 1; i < nums.length - 1; i++)
            if (nums[i + 1] - nums[i] != nums[1] - nums[0])
                return false;
        return true;
    }
}
