class Solution {
    public int[] assignTasks(int[] servers, int[] tasks) {
        int[] ans = new int[tasks.length];
        PriorityQueue<Integer> ready = new PriorityQueue<>((a, b) -> {
            return servers[a] == servers[b]?
                a - b : servers[a] - servers[b];
        });
        PriorityQueue<long[]> pending = new PriorityQueue<>(Comparator.comparingLong(o -> o[0]));

        for (int i = 0; i < servers.length; i++){
            ready.offer(i);
        }

        long time = 0;
        for (int i = 0; i < ans.length;){
            time = Math.max(i, time);
            while(!pending.isEmpty() && time >= pending.peek()[0]){
                ready.offer((int)pending.poll()[1]);
            }
            if (ready.isEmpty()){
                time = pending.peek()[0];
            }else{
                ans[i] = ready.poll();
                pending.offer(new long[]{time + tasks[i], ans[i++]});
            }
        }

        return ans;
    }
}
