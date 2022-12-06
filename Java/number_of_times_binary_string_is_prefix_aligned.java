class Solution {
    public int numTimesAllBlue(int[] flips) {
        int ans = 0, count = 0;
        PriorityQueue<Integer> minheap = new PriorityQueue<>();
        for (int i = 0; i < flips.length; i++){
            minheap.offer(flips[i]);
            while(!minheap.isEmpty() && minheap.peek() <= i + 1){
                minheap.poll();
                count++;
            }
            if (count == i + 1) ans++;
        }

        return ans;
    }
}
