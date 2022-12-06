class Solution {
    public int[] solve(int[] nums, int[][] queries) {
        int N = (int)(Math.sqrt(nums.length)+1), M = (int)1e9+7;
        int[] ans = new int[queries.length];
        int[][] buckets = new int[N][nums.length];
        for (int i = 1; i < N; i++){
            for (int j = nums.length-1; j >= 0; j--){
                buckets[i][j]=j+i>=nums.length?nums[j]:(nums[j]+buckets[i][j+i])%M;
            }
        }
        for (int i = 0; i < queries.length; i++){
            if (queries[i][1]<N){
                ans[i]=buckets[queries[i][1]][queries[i][0]];
            }else{
                for (int j = queries[i][0]; j<nums.length; j+=queries[i][1]){
                    ans[i]+=nums[j];
                    ans[i]%=M;
                }
            }
        }
        return ans;
    }
}
