class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        for (int i : nums)
            queue.offer(i);

        while(--k>0) queue.poll();

        return queue.poll();
    }
}
