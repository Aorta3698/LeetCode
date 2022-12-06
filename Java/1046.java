class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxheap = new PriorityQueue<>(Comparator.reverseOrder());
        for (int n : stones){
            maxheap.offer(n);
        }
        while(maxheap.size() > 1){
            int a = maxheap.poll();
            int b = maxheap.poll();
            if (a > b){
                maxheap.offer(a - b);
            }
        }
        return maxheap.isEmpty()? 0 : maxheap.peek();
    }
}
