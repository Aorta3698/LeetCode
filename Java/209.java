class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int ans = Integer.MAX_VALUE, sum = 0;
        Deque<Integer> deque = new ArrayDeque<>();
        for (int n : nums){
            sum += n;
            deque.offer(n);
            while(sum - deque.peekFirst() >= target) {
                sum -= deque.pollFirst();
            }
            if (sum >= target) ans = Math.min(ans, deque.size());
        }

        return ans == Integer.MAX_VALUE? 0 : ans;
    }
}
