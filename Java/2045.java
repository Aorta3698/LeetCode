class Solution {
    public int secondMinimum(int n, int[][] edges, int time, int change) {
        List<Integer>[] map = new ArrayList[n];
        Arrays.setAll(map, o -> new ArrayList<>());
        for (int[] e : edges){
            e[0]--; e[1]--;
            map[e[0]].add(e[1]);
            map[e[1]].add(e[0]);
        }

        Queue<Integer> queue = new ArrayDeque<>();
        int INF = (int)1e9;
        int SEEN = -1;
        int counter = 0;
        int best = INF;
        int offset = 2;
        int[] dist = new int[n];
        dist[0] = SEEN;
        queue.offer(0);
        while(!queue.isEmpty() && offset==2 && counter <= best+1){
            for (int sz = queue.size(); sz > 0; sz--){
                int cur = queue.poll();
                if (cur == n - 1){
                    if (best == INF){
                        best = counter;
                    }else if (best != counter){
                        offset=1;
                    }
                    continue;
                }
                for(int next : map[cur]){
                    if (dist[next]==0){
                        queue.offer(next);
                        dist[next] = counter+1;
                    }else if (dist[next]==counter){
                        queue.offer(next);
                        dist[next] = SEEN;
                    }
                }
            }
            counter++;
        }
        int ans = 0;
        for (int i = 0; i < best+offset; i++){
            ans = wait(ans, change) + time;
        }
        return ans;
    }

    private int wait(int cur, int change){
        if (cur/change%2==1){
            cur += change - cur%change;
        }
        return cur;
    }
}
