class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int ans = 0;
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        PriorityQueue<int[]> minheap = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        for (int[] i : intervals){
            minheap.add(i);
            while(minheap.peek()[1] <= i[0]) minheap.poll();
            ans = Math.max(ans, minheap.size());
        }

        return ans;
    }
}
