class Solution {
    public int constrainedSubsetSum(int[] nums, int k) {
        Deque<int[]> deque = new ArrayDeque<>();
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++){
            if (!deque.isEmpty() && i-deque.peekFirst()[0]>k){
                deque.pollFirst();
            }
            int[] cur = new int[]{i, deque.isEmpty()? nums[i] : Math.max(deque.peekFirst()[1]+nums[i], nums[i])};
            while(!deque.isEmpty() && cur[1]>deque.peekLast()[1]){
                deque.pollLast();
            }
            deque.offerLast(cur);
            ans = Math.max(ans, cur[1]);
        }

        return ans;
    }
}
