class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        Queue<Map.Entry<Integer, Integer>> seven = new LinkedList<>();
        Queue<Map.Entry<Integer, Integer>> thirty = new LinkedList<>();
        int ans = 0;

        for (int d : days){
            while (!thirty.isEmpty() && thirty.peek().getKey() + 30 <= d) thirty.poll();
            while (!seven.isEmpty() && seven.peek().getKey() + 7 <= d) seven.poll();

            thirty.offer(Map.entry(d, ans + costs[2]));
            seven.offer(Map.entry(d, ans + costs[1]));
            ans = Math.min(Math.min(seven.peek().getValue(), thirty.peek().getValue()), ans + costs[0]);
        }

        return ans;
    }
}
