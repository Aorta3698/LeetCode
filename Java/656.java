https://leetcode.com/problems/coin-path/discuss/2461376/Java-or-O(N)-or-DP-or-Backward
class Solution {
    public List<Integer> cheapestJump(int[] coins, int maxJump) {
        int n = coins.length;
        if (coins[n-1] == -1){
            return List.of();
        }
        List<Integer> ans = new ArrayList<>();
        Deque<Integer> deque = new ArrayDeque<>();
        int[] dp = new int[n];
        int[] parent = new int[n];
        dp[0]=parent[n-1]=-1;
        dp[n-1]=0;
        deque.offer(n-1);
        for (int i = n-2; i >= 0; i--){
            if (!deque.isEmpty() && deque.peekFirst()-i > maxJump){
                deque.pollFirst();
            }
            if (coins[i] == -1){
                continue;
            }
            if (deque.isEmpty()){
                break;
            }
            dp[i] = coins[i] + dp[deque.peekFirst()];
            parent[i] = deque.peekFirst();
            while(!deque.isEmpty() && dp[i] <= dp[deque.peekLast()]){
                deque.pollLast();
            }
            deque.offerLast(i);
        }
        int cur = 0;
        while(cur != -1 && dp[cur] != -1){
            ans.add(cur+1);
            cur=parent[cur];
        }

        return ans;
    }
}
