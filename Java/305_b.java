class Solution {
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        boolean[] bad = new boolean[n];
        for (int r : restricted){
            bad[r]=true;
        }
        List<Integer>[] map = new ArrayList[n];
        Arrays.setAll(map, o -> new ArrayList<>());
        for (int[] e : edges){
            if (bad[e[0]] || bad[e[1]]){
                continue;
            }
            map[e[0]].add(e[1]);
            map[e[1]].add(e[0]);
        }
        return dfs(0, -1, map);
    }

    private int dfs(int cur, int parent, List<Integer>[] map){
        int ans = 0;
        for (int next : map[cur]){
            if (next != parent){
                ans += dfs(next, cur, map);
            }
        }
        return ans+1;
    }
}
