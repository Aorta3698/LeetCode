class KthLargest {
    PriorityQueue<Integer> queue;
    int size;
    public KthLargest(int k, int[] nums) {
        size = k;
        queue = new PriorityQueue<>();
        for (int i : nums){
            queue.offer(i);
            if (queue.size() > k)
                queue.poll();
        }
    }

    public int add(int val) {
        queue.offer(val);
        if (queue.size() > size) queue.poll();
        return queue.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
