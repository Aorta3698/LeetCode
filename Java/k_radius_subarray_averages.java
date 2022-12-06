class Solution {
    public int[] getAverages(int[] nums, int k) {
        int[] ans = new int[nums.length];
        long sum = 0;
        for (int i = 0; i < ans.length; i++){
            if (i < k || ans.length - i - 1 < k) ans[i] = -1;
            else{
                if (i == k){
                    for (int j = i - k; j <= i + k; j++)
                        sum += nums[j];
                }
                else{
                    sum -= nums[i - k - 1];
                    sum += nums[i + k];
                }

                ans[i] = (int)(sum /(2*k+1));
            }
        }

        return ans;
    }
}
