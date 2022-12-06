class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] ans = new int[nums.length - k + 1];
        HashMap<Integer, Integer> count = new HashMap<>();
        PriorityQueue<Integer> maxheap = new PriorityQueue<>(Comparator.reverseOrder());
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < k; i++){
            count.merge(nums[i], 1, Integer::sum);
            max = Math.max(nums[i], max);
            maxheap.offer(nums[i]);
        }
        int idx = 0;
        ans[idx++] = max;
        for (int i = k; i < nums.length; i++){
            maxheap.offer(nums[i]);
            count.merge(nums[i], 1, Integer::sum);
            count.merge(nums[i - k], -1, Integer::sum);
            while(!maxheap.isEmpty() && count.get(maxheap.peek()) == 0) maxheap.poll();
            while(!maxheap.isEmpty() && (maxheap.peek() > max || count.get(max) == 0)) max = maxheap.poll();
            ans[idx++] = max;
        }

        return ans;
    }
}
