class Solution {
    public long minimalKSum(int[] nums, int k) {
        long ans = 0;
        Set<Integer> seen = new HashSet<>();
        Arrays.sort(nums);
        for (int n : nums) {
            if (n - seen.size() > k){
                break;
            }
            if (seen.add(n)){
                ans -= n;
            }
        }
        k += seen.size();
        ans += (long)(k + 1)*k/2;
        return ans;
    }
}
