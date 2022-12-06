class Solution {
    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        //Prim's ALGO
        boolean[] visited = new boolean[n + 1];
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        for (int i = 1; i <= wells.length; i++) queue.offer(new int[]{0, i, wells[i-1]});

        HashMap<Integer, List<int[]>> map = new HashMap<>();
        for (int i = 1; i <= wells.length; i++) {
            map.putIfAbsent(0, new ArrayList<>());
            map.putIfAbsent(i, new ArrayList<>());
            map.get(0).add(new int[]{i, wells[i-1]});
            map.get(i).add(new int[]{0, wells[i-1]});
        }
        for (int[] p : pipes){
            map.putIfAbsent(p[0], new ArrayList<>());
            map.putIfAbsent(p[1], new ArrayList<>());
            map.get(p[0]).add(new int[]{p[1], p[2]});
            map.get(p[1]).add(new int[]{p[0], p[2]});
        }

        int ans = 0;
        visited[0] = true;
        while(!queue.isEmpty()){
            int[] p = queue.poll();
            int cur = p[0];
            int dest = p[1];
            int cost = p[2];
            if (visited[dest]) continue;
            visited[dest] = true;
            ans += cost;
            for (int[] i : map.get(dest)){
                if (visited[i[0]]) continue;
                queue.offer(new int[]{dest, i[0], i[1]});
            }
        }

        return ans;
    }
}
