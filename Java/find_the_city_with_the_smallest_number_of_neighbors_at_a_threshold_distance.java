class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int ans = 0;
        HashMap<Integer, List<int[]>> map = new HashMap<>();
        for (int[] e : edges){
            map.computeIfAbsent(e[0], o -> new ArrayList<>()).add(new int[]{e[1], e[2]});
            map.computeIfAbsent(e[1], o -> new ArrayList<>()).add(new int[]{e[0], e[2]});
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++){
            PriorityQueue<int[]> minheap = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
            minheap.offer(new int[]{i, 0});
            boolean[] visited = new boolean[n];
            int[] best = new int[n];
            Arrays.fill(best, Integer.MAX_VALUE);
            best[i] = 0;

            int count = 0;
            while(!minheap.isEmpty() && map.containsKey(i)){
                int[] cur = minheap.poll();
                int p = cur[0];
                int d = cur[1];
                if (visited[p]) continue;
                count++;
                visited[p] = true;
                for (int[] v : map.get(p)){
                    int nd = d + v[1];
                    if (nd < best[v[0]] && nd <= distanceThreshold){
                        best[v[0]] = nd;
                        minheap.offer(new int[]{v[0], nd});
                    }
                }
            }

            if (count <= min){
                min = count;
                ans = i;
            }
        }

        return ans;
    }
}
