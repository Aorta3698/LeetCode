class Solution {
    public int[] getOrder(int[][] tasks) {
        int[] ans = new int[tasks.length];
        PriorityQueue<int[]> minheap = new PriorityQueue<>((a, b) -> a[0] == b[0]? a[1] - b[1] : a[0] - b[0]);
        Task[] all = new Task[ans.length];
        for (int i = 0; i < tasks.length; i++){
            all[i] = new Task(i, tasks[i][1], tasks[i][0]);
        }
        Arrays.sort(all, Comparator.comparingInt(o -> o.start));
        int time = 0;

        for (int i = 0, j = 0; j < ans.length;){
            while(i < all.length && all[i].start <= time){
                minheap.offer(new int[]{all[i].time, all[i++].idx});
            }
            if (!minheap.isEmpty()){
                ans[j++] = minheap.peek()[1];
                time += minheap.poll()[0];
            }else{
                time = all[i].start;
            }
        }

        return ans;
    }

    private class Task {
        int idx;
        int time;
        int start;
        Task (int idx, int time, int start){
            this.idx = idx;
            this.time = time;
            this.start = start;
        }
    }
}
