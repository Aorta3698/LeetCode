class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> minheap = new PriorityQueue<>();
        int ans = 0;
        while(ans < heights.length && bricks >= 0){
            if (ans < heights.length - 1 && heights[ans]<heights[ans+1]){
                minheap.offer(heights[ans+1]-heights[ans]);
                if (minheap.size()>ladders){
                    bricks -= minheap.poll();
                }
            }
            ans++;
        }
        return ans-1;
    }
}
