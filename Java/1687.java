https://leetcode.com/problems/delivering-boxes-from-storage-to-ports/discuss/2330389/Java-or-From-O(N2)-to-O(N)-or-MonoQueue-w-DP
class Solution {
    public int boxDelivering(int[][] boxes, int portsCount, int maxBoxes, int maxWeight) {
        int n = boxes.length, INF = (int)1e9;
        int[] dp = new int[n+1];
        Arrays.fill(dp, INF);
        dp[0]=0;
        Deque<int[]> deque = new ArrayDeque<>();
        long[] pre = new long[n+1];
        int[] diff= new int[n+1];
        for (int i = 1; i <= n; i++){
            pre[i]=boxes[i-1][1]+pre[i-1];
        }
        for (int i = 2; i <= n; i++){
            diff[i]=boxes[i-1][0]==boxes[i-2][0]?diff[i-1]:diff[i-1]+1;
        }
        deque.offer(new int[]{0, 0});
        for (int i = 1 ; i<=n; i++){
            while(i - deque.peekFirst()[0] > maxBoxes || pre[i] - pre[deque.peekFirst()[0]] > maxWeight){
                deque.pollFirst();
            }
            dp[i]=diff[i]-diff[deque.peekFirst()[0]+1]+dp[deque.peekFirst()[0]]+2;
            int cur = dp[i] - diff[i==n?0:i+1];
            while(!deque.isEmpty() && cur < deque.peekLast()[1]){
                deque.pollLast();
            }
            deque.offerLast(new int[]{i, cur});
        }
        return dp[n];
    }
}

// class Solution {
//     public int boxDelivering(int[][] boxes, int portsCount, int maxBoxes, int maxWeight) {
//         int n = boxes.length, INF = (int)1e9;
//         int[] dp = new int[n];
//         Arrays.fill(dp, INF);
//         dp[0]=2;
//         for (int i = 1 ; i<n; i++){
//             for (int j = i, w = 0, cur = 0; j >= 0; j--){
//                 w+=boxes[j][1];
//                 if (j==i||boxes[j][0]!=boxes[j+1][0]){
//                     cur++;
//                 }
//                 if (w <= maxWeight && cur <= maxBoxes){
//                     dp[i] = Math.min(dp[i], 1 + cur + (j==0?0:dp[j-1]));
//                 }else{
//                     break;
//                 }
//             }
//         }
//         return dp[n-1];
//     }
// }
