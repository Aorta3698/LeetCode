class Solution {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int[] dp = new int[nums2.length+1];
        int INF = (int)-1e9;
        for (int i = 1; i <= nums1.length; i++){
            int[] ndp = new int[nums2.length+1];
            for (int j = 1; j <= nums2.length; j++){
                int a = i==1?INF:dp[j];
                int b = j==1?INF:ndp[j-1];
                int c = max(nums1[i-1]*nums2[j-1]+dp[j-1], nums1[i-1]*nums2[j-1]);
                ndp[j]=max(a,b,c);
            }
            dp=ndp;
        }

        return dp[nums2.length];
    }

    private int max(int... a){
        return Arrays.stream(a).max().getAsInt();
    }
}
