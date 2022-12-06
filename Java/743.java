https://leetcode.com/problems/network-delay-time/discuss/2036263/Java-Dijkstra-Algo
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[--k] = 0;
        PriorityQueue<int[]> minheap = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
        minheap.offer(new int[]{0, k});

        List<int[]>[] all = new ArrayList[n];
        Arrays.setAll(all, o -> new ArrayList<>());
        for (int[] t : times){
            all[--t[0]].add(new int[]{--t[1], t[2]});
        }

        while(!minheap.isEmpty()){
            int d = minheap.peek()[0];
            int cur = minheap.poll()[1];
            if (dist[cur] != d)
                continue;
            k = cur;
            for (int[] next : all[k]){
                if (d + next[1] < dist[next[0]]){
                    dist[next[0]] = d + next[1];
                    minheap.offer(new int[]{dist[next[0]], next[0]});
                }
            }
            --n;
        }
        return n == 0? dist[k] : -1;
    }
}
