class Solution {
    public int numFactoredBinaryTrees(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length, ans = 0, M = (int)1e9+7;
        long[] dp = new long[n];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++){
            dp[i]=1;
            for (int j = 0; j < i; j++){
                if (arr[i]%arr[j]==0&&map.containsKey(arr[i]/arr[j])){
                    dp[i]+=dp[map.get(arr[i]/arr[j])]*dp[j];
                    dp[i]%=M;
                }
            }
            // for (int j = 2; j*j <= arr[i]; j++){
            //     if (arr[i]%j==0 && map.containsKey(arr[i]/j) && map.containsKey(j)){
            //         dp[i]+=dp[map.get(arr[i]/j)]*dp[map.get(j)]*(j*j!=arr[i]?2:1);
            //         dp[i]%=M;
            //     }
            // }
            map.put(arr[i], i);
            ans += dp[i];
            ans %= M;
        }
        return ans;
    }
}
