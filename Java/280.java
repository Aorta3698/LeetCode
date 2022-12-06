class Solution {
    public void wiggleSort(int[] nums) {
        PriorityQueue<Integer> maxheap = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> minheap = new PriorityQueue<>();
        for (int n : nums){
            maxheap.offer(n);
            minheap.offer(n);
        }

        for (int i = 0; i < nums.length; i++)
            nums[i] = i % 2 == 0? minheap.poll() : maxheap.poll();
    }
}
