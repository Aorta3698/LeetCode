class Solution {
    private final int M = (int)1e9 + 7;
    public int countPaths(int n, int[][] roads) {
        HashMap<Integer, List<int[]>> map = new HashMap<>();
        for (int[] r : roads){
            map.computeIfAbsent(r[0], o -> new ArrayList<>()).add(new int[]{r[1], r[2]});
            map.computeIfAbsent(r[1], o -> new ArrayList<>()).add(new int[]{r[0], r[2]});
        }

        long[] best = new long[n];
        Arrays.fill(best, Long.MAX_VALUE);
        best[0] = 0;

        boolean[] seen = new boolean[n];

        int[] ways = new int[n];
        ways[0] = 1;

        PriorityQueue<long[]> minheap = new PriorityQueue<>(Comparator.comparingLong(o -> o[0]));
        minheap.offer(new long[]{0, 0});

        while(!minheap.isEmpty()){
            long[] cur = minheap.poll();
            long dist = cur[0];
            int city = (int)cur[1];
            if (seen[city]) continue;
            seen[city] = true;
            if (map.containsKey(city)){
                for (int[] v : map.get(city)){
                    int nCity = (int)v[0];
                    long nDist = v[1] + dist;
                    if (seen[nCity] || nDist > best[nCity]) continue;
                    if (nDist == best[nCity]){
                        ways[nCity] += ways[city];
                        ways[nCity] %= M;
                    }
                    if (nDist < best[nCity]){
                        ways[nCity] = ways[city];
                        best[nCity] = nDist;
                    }

                    minheap.offer(new long[]{nDist, nCity});
                }
            }
        }

        return ways[n - 1];
    }
}
