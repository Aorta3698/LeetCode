class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        Queue<Integer> queue = new ArrayDeque<>();
        tickets[k] += 101;
        for (int t : tickets) queue.offer(t);
        int ans = 0;
        while(!queue.isEmpty()){
            ans++;
            if (queue.peek() == 1) queue.poll();
            else if (queue.peek() - 1 == 101) break;
            else queue.offer(queue.poll() - 1);
        }

        return ans;
    }
}
