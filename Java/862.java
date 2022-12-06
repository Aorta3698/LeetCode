class Solution {
    public int shortestSubarray(int[] nums, int k) {
        int ans = Integer.MAX_VALUE, n = nums.length;
        long[] pre = new long[n + 1];
        for (int i = 0; i < n; i++) pre[i + 1] = pre[i] + nums[i];
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i <= n; i++){
            while(!deque.isEmpty() && pre[i] - pre[deque.peekFirst()] >= k){
                ans = Math.min(i - deque.pollFirst(), ans);
            }
            while(!deque.isEmpty() && pre[i] <= pre[deque.peekLast()]){
                deque.pollLast();
            }
            deque.offer(i);
        }

        return ans == Integer.MAX_VALUE? -1 : ans;
    }
    //no neg end or start
    //ppnnn -> neg or 0, delete them all
    //excess -> remove pos until excess is at minimum
    //watch out for cases like 300, 100, -200, 1000 and target = 999
}
