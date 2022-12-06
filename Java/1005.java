https://leetcode.com/problems/maximize-sum-of-array-after-k-negations/discuss/1642143/Java-or-PriorityQueue-or-8-Lines-or-Explained.
class Solution {
    public int largestSumAfterKNegations(int[] nums, int k) {
        int ans = 0, min = Integer.MAX_VALUE;
        PriorityQueue<Integer> minheap = new PriorityQueue<>();
        for (int n : nums){
            if (n < 0) minheap.offer(n);
            min = Math.min(Math.abs(n), min);
            ans += n;
        }

        while(!minheap.isEmpty() && --k >= 0)
            ans -= 2 * minheap.poll();

        return k % 2 == 1? ans -= 2 * min : ans;
    }
}
