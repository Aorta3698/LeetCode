class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] red_edges, int[][] blue_edges) {
        int[] ans = new int[n];
        HashMap<Integer, List<Integer>> red = buildMap(red_edges);
        HashMap<Integer, List<Integer>> blue = buildMap(blue_edges);
        for (int i = 1; i < n; i++){
            Queue<int[]> queue = new LinkedList<>();
            queue.offer(new int[]{0, 0}); //cur. 1 is red, 2 is blue.
            int[][] visited = new int[n][3];
            int step = 0;
            while(!queue.isEmpty()){
                int size = queue.size();
                while(size-->0){
                    int[] cur = queue.poll();
                    int pos = cur[0];
                    int color = cur[1];
                    if (visited[pos][0] == 1 && visited[pos][color] == 1) continue;
                    visited[pos][0] = 1;
                    visited[pos][color] = 1;

                    if (pos == i) {
                        ans[i] = step;
                        break;
                    }

                    if (blue.containsKey(pos) && color != 2)
                        for (int p : blue.get(pos))
                            queue.offer(new int[]{p, 2, pos});
                    if (red.containsKey(pos) && color != 1)
                        for (int p : red.get(pos))
                            queue.offer(new int[]{p, 1, pos});
                }
                step++;
                if (ans[i] != 0) break;
            }

            if (ans[i] == 0) ans[i] = -1;
        }

        return ans;
    }

    private HashMap<Integer, List<Integer>> buildMap(int[][] m){
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int[] n : m)
            map.computeIfAbsent(n[0], o -> new ArrayList<>()).add(n[1]);
        return map;
    }
}
