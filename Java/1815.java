class Solution {
    public int maxHappyGroups(int n, int[] groups) {
        int[] freq = new int[n];
        for (int g : groups){
            freq[g%n]++;
        }
        Map<Integer, Integer>[] map = new HashMap[9];
        Arrays.setAll(map, o -> new HashMap<>());
        return solve(0, n, freq, map);
    }

    private int solve(int cur, int batch, int[] freq, Map<Integer, Integer>[] memo){
        int key = hash(freq);
        if (key == 0){
            return 0;
        }
        if (memo[cur].containsKey(key)){
            return memo[cur].get(key);
        }
        int ans = 0;
        for (int i = 0; i < freq.length; i++){
            if (freq[i]>0){
                freq[i]--;
                ans = Math.max(solve((cur+i)%batch, batch, freq, memo), ans);
                freq[i]++;
            }
        }
        ans += (cur==0?1:0);
        memo[cur].put(key, ans);
        return ans;
    }

    private int hash (int[] arr){
        int h = 0;
        for (int n : arr){
            h += n;
            h *= 31;
        }
        return h;
    }
}


// class Solution {
//     public int maxHappyGroups(int batchSize, int[] groups) {
//         int n = groups.length;
//         int[] sum = new int[1<<n];
//         for (int i = 0 ; i< n; i++){
//             sum[1<<i]=groups[i]%batchSize;
//         }
//         for (int i = 1; i <1<<n; i++){
//             sum[i]=(sum[i&-i]+sum[i&(i-1)])%batchSize;
//         }
//         int[] dp = new int[1<<n];
//         // int max=0;
//         // for (int i = 0; i < 1<<n; i++){
//         //     for (int j = i; j > 0 && sum[i]==0; j=(j-1)&i){
//         //         dp[i]=Math.max(1, dp[i]);
//         //         if (sum[i^j]==0&&sum[j]==0){
//         //             dp[i]=Math.max(dp[i],dp[i^j]+dp[j]);
//         //         }
//         //         if (dp[i]>dp[max]){
//         //             max=i;
//         //         }
//         //     }
//         // }
//         for (int i = 0; i < 1<<n; i++){
//             for (int j = 0; j < n; j++){
//                 // if ((i&1<<j)>0){
//                 //     dp[i]=Math.max(dp[i],dp[i^1<<j]+(sum[i]==0?1:0));
//                 // }
//                 if ((i&1<<j)==0){
//                     dp[i|1<<j]=Math.max(dp[i|1<<j], dp[i]+(sum[i|1<<j]==0?1:0));
//                 }
//             }
//         }
//         return dp[(1<<n)-1];
//         // return dp[max]+((sum[((1<<n)-1)^max]+batchSize-1)/batchSize);
//         // System.out.println(Integer.toBinaryString(max));
//         // System.out.println(sum[(1<<n)-1]);
//         // return dp[max];
//     }
// }
