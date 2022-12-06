class Solution {
    public int maxEvents(int[][] events) {
        int ans = 0;
        Arrays.sort(events, Comparator.comparingInt(o -> o[0]));
        PriorityQueue<Integer> minheap = new PriorityQueue<>();
        int time = 0, i = 0;
        while (true){
            while(i < events.length && time >= events[i][0]){
                minheap.offer(events[i++][1]);
            }
            while(!minheap.isEmpty() && time > minheap.peek()){
                minheap.poll();
            }
            if (i == events.length && minheap.isEmpty())
                break;
            if (!minheap.isEmpty()){
                minheap.poll();
                time++;
                ans++;
            }else{
                time = events[i][0];
            }
        }

        return ans;
    }
}
