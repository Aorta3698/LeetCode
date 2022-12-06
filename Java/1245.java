class Solution {
    public int treeDiameter(int[][] edges) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] e : edges){
            map.computeIfAbsent(e[0], o -> new ArrayList<>()).add(e[1]);
            map.computeIfAbsent(e[1], o -> new ArrayList<>()).add(e[0]);
        }

        return --dfs(map, dfs(map, 0, -1)[1], -1)[0];
    }

    private int[] dfs(Map<Integer, List<Integer>> map, int idx, int parent){
        int[] max = new int[2];
        if (map.get(idx).size() == 1) max[1] = idx;
        for (int next : map.get(idx)){
            if (next == parent) continue;
            int[] res = dfs(map, next, idx);
            if (res[0] > max[0]) max = res;
        }

        max[0]++;
        return max;
    }
}
