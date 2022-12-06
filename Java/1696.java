https://leetcode.com/problems/jump-game-vi/discuss/1902237/Java-or-Keep-a-Max-Deque
class Solution {
    public int maxResult(int[] nums, int k) {
        Deque<int[]> deque = new ArrayDeque<>();
        deque.offer(new int[]{0, nums[0]});

        for (int i = 1; i < nums.length; i++){
            int max = deque.peek()[1];
            int[] next = new int[]{i, max + nums[i]};
            while (!deque.isEmpty() && deque.peekLast()[1] <= next[1]){
                deque.pollLast();
            }

            deque.offer(next);

            if (deque.peekFirst()[0] <= i - k){
                deque.pollFirst();
            }
        }

        return deque.peekLast()[1];
    }
}
