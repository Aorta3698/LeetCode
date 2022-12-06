class Solution {
    public int networkBecomesIdle(int[][] edges, int[] patience) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int[] e : edges){
            map.computeIfAbsent(e[0], o -> new ArrayList<>()).add(e[1]);
            map.computeIfAbsent(e[1], o -> new ArrayList<>()).add(e[0]);
        }

        boolean[] seen = new boolean[patience.length];
        int[] dist = new int[seen.length];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);

        int d = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size-- > 0){
                int cur = queue.poll();
                if (seen[cur]) continue;
                dist[cur] = d;
                seen[cur] = true;

                for (int v : map.get(cur))
                    queue.offer(v);
            }
            d++;
        }

        int max = 0;
        for (int i = 1; i < dist.length; i++){
            int distFromServer = (2 * dist[i]) % patience[i];
            if (distFromServer == 0) distFromServer = patience[i];
            int tDist = 2 * dist[i] <= patience[i]? 2 * dist[i] : dist[i] * 4 - distFromServer;
            max = Math.max(tDist, max);
        }

        return max + 1;
    }
}
