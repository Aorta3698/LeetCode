class Solution {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (List<Integer> c : connections){
            map.computeIfAbsent(c.get(0), o -> new ArrayList<>()).add(c.get(1));
            map.computeIfAbsent(c.get(1), o -> new ArrayList<>()).add(c.get(0));
        }
        int[] low = new int[n];
        Arrays.fill(low, -1);
        int[] pre = low.clone();

        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < n; i++)
            if (pre[i] == -1)
                dfs(map, i, i, pre, low, ans, new AtomicInteger(0));

        return ans;
    }

    private void dfs(HashMap<Integer, List<Integer>> map, int u, int v, int[] pre, int[] low,
            List<List<Integer>> ans, AtomicInteger cnt){

        pre[v] = low[v] = cnt.getAndIncrement();
        for (int g : map.get(v)){
            if (pre[g] == -1){
                dfs(map, v, g, pre, low, ans, cnt);
                low[v] = Math.min(low[v], low[g]);
                if (low[g] == pre[g]) ans.add(new ArrayList<>(List.of(v, g)));
            }
            else if (g != u) low[v] = Math.min(low[v], low[g]);
        }
    }
}
