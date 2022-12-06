class Solution {
    public int maximumSum(int[] nums) {
        int[] max = new int[100];
        int ans = -1;
        for (int n : nums){
            int cur = n;
            int sum = 0;
            while(n>0){
                sum+=n%10;
                n/=10;
            }
            if (max[sum]>0){
                ans=Math.max(ans, max[sum]+cur);
            }
            max[sum]=Math.max(cur, max[sum]);
        }
        return ans;
    }
}
