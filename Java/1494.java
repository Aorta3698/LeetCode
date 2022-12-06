https://leetcode.com/problems/parallel-courses-ii/discuss/2212603/Java-Short-DP
class Solution {
    public int minNumberOfSemesters(int n, int[][] relations, int k) {
        int[] ok = new int[1 << n];
        int[] dp = new int[1 << n];
        Arrays.fill(dp, 30);
        dp[0]=0;
        for (int[] r : relations){
            ok[r[1]-1] |= 1<<(r[0]-1);
        }
        for (int i = 0; i < 1<<n; i++){
            if (dp[i]!=30){
                tryAll(0, k, i, i, n, ok, dp);
            }
        }
        return dp[(1<<n)-1];
    }

    private void tryAll(int idx, int k, int cur, int old, int n, int[] ok, int[] dp){
        for (int i = idx; i < n && k > 0; i++){
            if ((old&(1<<i))==0&&(old&ok[i])==ok[i]){
                tryAll(i+1, k-1, cur|1<<i, old, n, ok, dp);
            }
        }
        dp[cur]=Math.min(dp[cur], dp[old]+1);
    }
}

// class Solution {
//     public int minNumberOfSemesters(int n, int[][] relations, int k) {
//         int[] ok = new int[1 << n];
//         int[] dp = new int[1 << n];
//         Arrays.fill(dp, 30);
//         dp[0]=0;
//         for (int[] r : relations){
//             ok[r[1]-1] |= 1<<(r[0]-1);
//         }
//         for (int i = 0; i < 1<<n; i++){
//             if (dp[i]==30){
//                 continue;
//             }
//             List<Integer> canTake = new ArrayList<>();
//             for (int j = 0; j < n; j++){
//                 if ((i&(1<<j))==0&&(i&ok[j])==ok[j]){
//                     canTake.add(j);
//                 }
//             }
//             tryAll(0, k, i, i, canTake, dp);
//         }
//         return dp[(1<<n)-1];
//     }

//     private void tryAll(int idx, int k, int cur, int old, List<Integer> canTake, int[] dp){
//         if (k==0||idx==canTake.size()){
//             dp[cur]=Math.min(dp[cur], dp[old]+1);
//             return;
//         }
//         for (int i = idx; i < canTake.size(); i++){
//             tryAll(i+1, k-1, cur|1<<canTake.get(i), old, canTake, dp);
//         }
//     }
// }
