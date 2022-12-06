class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxheap = new PriorityQueue<>(Comparator.reverseOrder());
        for (int s : stones) maxheap.offer(s);
        while(maxheap.size() > 1) maxheap.offer(maxheap.poll() - maxheap.poll());
        return maxheap.isEmpty()? 0 : maxheap.peek();
    }
}
