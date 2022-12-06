class Solution {
    public int sumOfFlooredPairs(int[] nums) {
        Arrays.sort(nums);
        int[] all = new int[200001];
        int[] cnt = new int[100001];
        for (int i = 0, j = 0; i < 200001; i++){
            while(j < nums.length && i > nums[j]){
                ++cnt[nums[j++]];
            }
            all[i] = j;
        }
        long ans = 0;
        int M = (int)1e9+7;;
        for (int k = 0; k < 100001; k++){
            long cur = 0;
            for (int i = k, p = 0, j = 0; cnt[k] > 0; i+=k, j++){
                cur += 1L * (all[i] - p) * j;
                cur %= M;
                p = all[i];
                if (i > 100000){
                    break;
                }
            }
            ans += 1L * cur * cnt[k];
            ans %= M;
        }
        return (int)ans;
    }
}
