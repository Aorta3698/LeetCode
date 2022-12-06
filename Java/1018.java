class Solution {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        List<Boolean> ans = new ArrayList<>();
        int cur = 0;
        for (int n : nums){
            cur <<= 1;
            cur += n;
            cur %= 5;
            ans.add(cur == 0);
        }

        return ans;
    }
}
