class Solution {
    public int connectSticks(int[] sticks) {
        PriorityQueue<Integer> minheap = new PriorityQueue<>();
        for (int s : sticks) minheap.offer(s);

        int ans = 0;
        while(minheap.size() > 1){
            int next = minheap.poll() + minheap.poll();
            ans += next;
            minheap.offer(next);
        }

        return ans;
    }
}
