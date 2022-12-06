class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        PriorityQueue<Integer> minheap = new PriorityQueue<>();
        for (int i = 0; i < rocks.length; i++){
            minheap.offer(capacity[i] - rocks[i]);
        }
        while(!minheap.isEmpty() && additionalRocks > 0){
            additionalRocks -= minheap.poll();
        }
        return rocks.length - minheap.size() - (additionalRocks < 0? 1 : 0);
    }
}
