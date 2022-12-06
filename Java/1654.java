class Solution {
    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        int ttl = 6001, ans = 0;
        boolean[] ban = new boolean[ttl];
        for (int n : forbidden){
            ban[n] = true;
        }
        boolean[][] seen = new boolean[ttl][2];
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{0, 0});
        seen[0][0] = true;

        while(!queue.isEmpty()){
            int sz = queue.size();
            while(--sz >= 0){
                int cur = queue.peek()[0];
                int count = queue.poll()[1];
                if (cur == x)
                    return ans;
                if (cur + a < ttl && !seen[cur + a][0] && !ban[cur + a]){
                    seen[cur + a][0] = true;
                    queue.offer(new int[]{cur + a, 0});
                }
                if (cur - b >= 0 && !seen[cur - b][0] && !seen[cur - b][1] && count == 0 && !ban[cur - b]){
                    seen[cur - b][1] = true;
                    queue.offer(new int[]{cur - b, 1});
                }
            }
            ans++;
        }

        return -1;
    }
}
