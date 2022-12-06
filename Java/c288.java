class Solution {
    public int maximumProduct(int[] nums, int k) {
        PriorityQueue<Integer> minheap = new PriorityQueue<>();
        for (int n : nums){
            minheap.offer(n);
        }
        while(--k >= 0){
            minheap.offer(minheap.poll() + 1);
        }
        long ans = 1;
        while(minheap.size() > 0){
            ans = (ans * minheap.poll()) % (int)(1e9 + 7);
        }

        return (int)ans;
    }
}
