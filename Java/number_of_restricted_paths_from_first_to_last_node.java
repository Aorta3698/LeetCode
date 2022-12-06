class Solution {
    private final int M = (int)1e9+7;
    public int countRestrictedPaths(int n, int[][] edges) {
        HashMap<Integer, List<int[]>> map = new HashMap<>();
        for (int[] e : edges){
            map.computeIfAbsent(e[0] - 1, o -> new ArrayList<>()).add(new int[]{e[1] - 1, e[2]});
            map.computeIfAbsent(e[1] - 1, o -> new ArrayList<>()).add(new int[]{e[0] - 1, e[2]});
        }

        boolean[] seen = new boolean[n];

        int[] best = new int[n];
        Arrays.fill(best, Integer.MAX_VALUE);
        best[n-1] = 0;

        PriorityQueue<int[]> minheap = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
        minheap.offer(new int[]{0, n - 1});

        while(!minheap.isEmpty()){
            int[] cur = minheap.poll();
            int dist = cur[0];
            int idx = cur[1];
            if (seen[idx]) continue;

            for (int[] v : map.get(idx)){
                int ni = v[0];
                int nDist = dist + v[1];
                if (seen[idx] || nDist >= best[ni]) continue;
                minheap.offer(new int[]{nDist, ni});
                best[ni] = nDist;
            }
        }

        return dfs(0, n - 1, best, map, new HashMap<Integer, Integer>());
    }

    private int dfs(int start, int end, int[] best, HashMap<Integer, List<int[]>> map,
            HashMap<Integer, Integer> memo){
        if (start == end) return 1;
        if (memo.containsKey(start)) return memo.get(start);

        int sum = 0;
        for (int[] v : map.get(start)){
            int next = v[0];
            if (best[start] <= best[next]) continue;
            sum += dfs(next, end, best, map, memo);
            sum %= M;
        }

        memo.put(start, sum);
        return sum;
    }
}
