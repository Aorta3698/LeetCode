class Solution {
    public int countDistinct(int[] nums, int k, int p) {
        int ans = 0;
        Set<String> seen = new HashSet<>();
        for (int i = 0; i < nums.length; i++){
            int cnt = 0;
            StringBuilder sb = new StringBuilder();
            for (int j = i; j < nums.length && cnt <= k; j++){
                sb.append(",");
                sb.append(nums[j]);
                if (nums[j] % p == 0){
                    cnt++;
                }
                if (cnt <= k && !seen.contains(sb.toString())){
                    seen.add(sb.toString());
                    ans++;
                }
            }
        }
        return ans;
    }
}
