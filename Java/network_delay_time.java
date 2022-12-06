class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        HashMap<Integer, HashMap<Integer, Integer>> map = new HashMap<>();
        for (int[] t : times){
            map.putIfAbsent(t[0], new HashMap<>());
            map.get(t[0]).put(t[1], t[2]);
        }
        boolean[] visited = new boolean[n+1];
        HashMap<Integer, Integer> best = new HashMap<>();
        best.put(k, 0);

        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        queue.offer(new int[]{0, k});

        int max = 0;
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int idx = cur[1];
            int dist = cur[0];
            if (visited[idx]) continue;
            visited[idx] = true;

            max = dist;
            // n--;

            if (!map.containsKey(idx)) continue;
            for (int next : map.get(idx).keySet()){
                int nDist = dist + map.get(idx).get(next);
                if (!best.containsKey(next) || nDist < best.get(next)){
                    best.put(next, nDist);
                    queue.offer(new int[]{nDist, next});
                }
            }
        }

        return best.size() == n? max : -1;
    }
}
